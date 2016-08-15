/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.rmi;

import java.rmi.RemoteException;
import org.Banque.entities.Compte;
import org.Banque.metier.CompteMetier;
import org.Banque.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ayoub
 */
@Component("myRmiService")
public class BanqueRmiImpl implements BanqueRmiRemote
{
    @Autowired
    private CompteMetier compteMetier;
    
    @Autowired
    private OperationMetier operationMetier;

    @Override
    public Compte saveCompte(Compte cp) throws RemoteException
    {
        return compteMetier.saveCompte(cp);
    }

    @Override
    public Compte getCompte(String code) throws RemoteException
    {
        return compteMetier.getCompte(code);
    }

    @Override
    public boolean verser(String code, double montant, Long codeEmp) throws RemoteException
    {
        return operationMetier.verser(code, montant, codeEmp);
    }

    @Override
    public boolean retirer(String code, double montant, Long codeEmp) throws RemoteException
    {
        return operationMetier.retirer(code, montant, codeEmp);
    }

    @Override
    public boolean virement(String codeCompteFrom, String codeCompteTo, double solde, Long codeEmp) throws RemoteException
    {
        return operationMetier.virement(codeCompteFrom, codeCompteTo, solde, codeEmp);
    }
    
    
}
