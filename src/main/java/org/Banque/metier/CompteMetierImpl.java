/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.metier;

import java.util.Date;
import org.Banque.dao.CompteRepository;
import org.Banque.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompteMetierImpl implements CompteMetier
{
    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Compte saveCompte(Compte c)
    {
        c.setDateCreation(new Date());
        return compteRepository.save(c);
    }

    @Override
    public Compte getCompte(String code)
    {
        Compte cp = compteRepository.findOne(code);
        
        if(cp == null)
            throw new RuntimeException("Compte Innexistant");
        
        return cp;
    }

    
    
    
}
