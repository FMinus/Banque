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
@DiscriminatorValue("CE")
@XmlType(name = "CE")
public class CompteEpargne extends Compte
{
    private double taux;

    public CompteEpargne()
    {
    }

    public CompteEpargne(String codeCompte, Date dateCreation, double solde,double taux)
    {
        super(codeCompte, dateCreation, solde);
        this.taux = taux;
    }

    public double getTaux()
    {
        return taux;
    }

    public void setTaux(double taux)
    {
        this.taux = taux;
    }
    
    
}
