/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.services;

import org.Banque.metier.OperationMetier;
import org.Banque.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ayoub
 */
@RestController
public class OperationRestService
{
    @Autowired
    private OperationMetier operationMetier;
    
    @RequestMapping(value = "/operations",method = RequestMethod.GET)
    public PageOperation getOperations(@RequestParam String codeCompte, @RequestParam int pageStart, @RequestParam int size)
    {
        return operationMetier.getOperations(codeCompte, pageStart, size);
    }

    @RequestMapping(value = "/versement",method = RequestMethod.PUT)
    public boolean verser(
            @RequestParam String code,
            @RequestParam double montant,
            @RequestParam Long codeEmp)
    {
        return operationMetier.verser(code, montant, codeEmp);
    }
    
    @RequestMapping(value = "/retirer",method = RequestMethod.PUT)
    public boolean retirer(
            @RequestParam String code,
            @RequestParam double montant,
            @RequestParam Long codeEmp)
    {
        return operationMetier.retirer(code, montant, codeEmp);
    }
    
    @RequestMapping(value = "/virement",method = RequestMethod.PUT)
    public boolean virement(
            @RequestParam String codeCompteFrom,
            @RequestParam String codeCompteTo,
            @RequestParam double solde,
            @RequestParam Long codeEmp)
    {
        return operationMetier.virement(codeCompteFrom, codeCompteTo, solde, codeEmp);
    }
}
