/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.metier;

import java.util.List;
import org.Banque.entities.Compte;

/**
 *
 * @author Ayoub
 */
public interface CompteMetier
{
    public Compte saveCompte(Compte c);
    public Compte getCompte(String code);
}
