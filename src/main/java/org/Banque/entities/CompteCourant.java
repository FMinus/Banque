/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.entities;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Ayoub
 */
@Entity
@DiscriminatorValue("CC")
@XmlType(name = "CC")
public class CompteCourant extends Compte 
{
    private double decouvert;

    public CompteCourant()
    {
    }

    public CompteCourant(double decouvert, String codeCompte, Date dateCreation, double solde)
    {
        super(codeCompte, dateCreation, solde);
        this.decouvert = decouvert;
    }

    public double getDecouvert()
    {
        return decouvert;
    }

    public void setDecouvert(double decouvert)
    {
        this.decouvert = decouvert;
    }

    
    
    
    
}
