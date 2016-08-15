/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import org.Banque.entities.Compte;

/**
 *
 * @author Ayoub
 */
public interface BanqueRmiRemote extends Remote
{
    public Compte saveCompte(Compte cp) throws RemoteException;
    public Compte getCompte(String code) throws RemoteException;
    public boolean verser(String code,double montant,Long codeEmp) throws RemoteException;
    public boolean retirer(String code,double montant,Long codeEmp) throws RemoteException;
    public boolean virement(String codeCompteFrom,String codeCompteTo,double solde,Long codeEmp) throws RemoteException;
}
