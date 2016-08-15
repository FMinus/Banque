/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.metier;

import java.util.List;
import org.Banque.entities.Operation;


public interface OperationMetier
{
    public boolean verser(String code,double montant,Long codeEmp);
    public boolean retirer(String code,double montant,Long codeEmp);
    public boolean virement(String codeCompteFrom,String codeCompteTo,double solde,Long codeEmp);
    public PageOperation getOperations(String codeCompte,int pageStart,int size);
}
