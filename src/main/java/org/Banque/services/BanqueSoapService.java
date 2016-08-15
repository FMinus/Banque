/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.Banque.entities.Compte;
import org.Banque.metier.CompteMetier;
import org.Banque.metier.OperationMetier;
import org.Banque.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ayoub
 */
@WebService
@Component
public class BanqueSoapService
{
    @Autowired
    private CompteMetier compteMetier;
    
    @Autowired
    private OperationMetier operationMetier;
    
    @WebMethod
    public PageOperation getOperations(
            @WebParam(name = "codeCompte") String codeCompte,
            @WebParam(name = "pageStart")  int pageStart,
            @WebParam(name = "size")  int size)
    {
        return operationMetier.getOperations(codeCompte, pageStart, size);
    }

    @WebMethod
    public Compte getCompte(@WebParam(name = "code") String code)
    {
        return compteMetier.getCompte(code);
    }
    
    @WebMethod
    public boolean verser(
            @WebParam(name = "code") String code,
            @WebParam(name = "montant")  double montant,
            @WebParam(name = "codeEmp")  Long codeEmp)
    {
        return operationMetier.verser(code, montant, codeEmp);
    }
    
    @WebMethod
    public boolean retirer(
            @WebParam(name = "code") String code,
            @WebParam(name = "montant")  double montant,
            @WebParam(name = "codeEmp")  Long codeEmp)
    {
        return operationMetier.retirer(code, montant, codeEmp);
    }
    
    @WebMethod
    public boolean virement(
            @WebParam(name = "codeCompteFrom") String codeCompteFrom,
            @WebParam(name = "codeCompteTo")  String codeCompteTo,
            @WebParam(name = "montant")  double solde,
            @WebParam(name = "codeEmp")  Long codeEmp)
    {
        return operationMetier.virement(codeCompteFrom, codeCompteTo, solde, codeEmp);
    }

   
    
    
    
}
