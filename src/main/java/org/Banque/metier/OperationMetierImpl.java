/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.metier;

import java.util.Date;
import org.Banque.dao.CompteRepository;
import org.Banque.dao.EmployeRepository;
import org.Banque.dao.OperationRepository;
import org.Banque.entities.Compte;
import org.Banque.entities.Operation;
import org.Banque.entities.Retrait;
import org.Banque.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ayoub
 */
@Service
public class OperationMetierImpl implements OperationMetier
{
    @Autowired
    private OperationRepository operationRepository;
    
    @Autowired
    private CompteRepository compteRepository;
    
    @Autowired
    private EmployeRepository employeRepository;
    
    @Override
    @Transactional //tous changement sur les objets sera enregistrer : tous marche ou rien n'est enregister
    public boolean verser(String code, double montant, Long codeEmp)
    {
        //debut transaction
        
        Compte cp = compteRepository.findOne(code);
        Operation op = new Versement();
        
        op.setDateOperation(new Date());
        op.setMontant(montant);
        op.setEmploye(employeRepository.findOne(codeEmp));
        op.setCompte(compteRepository.findOne(code));
        
        operationRepository.save(op);
        cp.setSolde(cp.getSolde()+montant);
        
        
        //fin transaction
        return true;
        
    }

    @Override
    @Transactional //if all methods will be transactional then better add in the class 
    public boolean retirer(String code, double montant, Long codeEmp)
    {
        
        Compte cp = compteRepository.findOne(code);
        Operation op = new Retrait();
        
        if(cp.getSolde()<montant) 
            throw new RuntimeException("solde insuffisant");
        
        
        op.setDateOperation(new Date());
        op.setMontant(montant);
        op.setEmploye(employeRepository.findOne(codeEmp));
        op.setCompte(compteRepository.findOne(code));
        
        operationRepository.save(op);
        cp.setSolde(cp.getSolde()-montant);
        
        return true;
    }

    @Override
    @Transactional
    public boolean virement(String codeCompteFrom, String codeCompteTo, double solde, Long codeEmp)
    {
         
        retirer(codeCompteFrom, solde, codeEmp);
        verser(codeCompteTo, solde, codeEmp);
        return true;
    }

    @Override
    public PageOperation getOperations(String codeCompte, int pageStart, int size)
    {
        //solution 1 :
        Page<Operation> ops = operationRepository.getOperations(codeCompte, new PageRequest(pageStart, size));
        
        /*
        //solution 2:
        Compte cp = compteRepository.findOne(codeCompte);
        //2 requette pour un seul resultat : 1ere solution plus pratique
        Page<Operation> ops2 = compteRepository.findByCompte(cp,pageable);
        */
        
        PageOperation pOp = new PageOperation();
        pOp.setOperations(ops.getContent());
        pOp.setNombreOperations(ops.getNumberOfElements());
        pOp.setPage(ops.getNumber());  //pOp.setPage(pageStart);
        pOp.setTotalPages(ops.getTotalPages());
        pOp.setTotalOperations((int) ops.getNumberOfElements());
        return pOp;
    }
    
    
}
