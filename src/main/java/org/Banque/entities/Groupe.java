/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Ayoub
 */

@Entity
//@Table(name = "groupe")
public class Groupe implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeGroupe;
    
    private String nomGroupe;
    
    @ManyToMany(mappedBy = "groupes")
    private Collection<Employe> employes;

    public Groupe()
    {
    }

    public Groupe(String nomGroupe)
    {
        this.nomGroupe = nomGroupe;
    }

    public Long getCodeGroupe()
    {
        return codeGroupe;
    }

    public void setCodeGroupe(Long codeGroupe)
    {
        this.codeGroupe = codeGroupe;
    }

    public String getNomGroupe()
    {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe)
    {
        this.nomGroupe = nomGroupe;
    }

    public Collection<Employe> getEmployes()
    {
        return employes;
    }

    public void setEmployes(Collection<Employe> employes)
    {
        this.employes = employes;
    }
    
    
}
