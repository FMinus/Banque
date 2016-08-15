/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ayoub
 */
@Entity
public class Employe implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeEmploye;
    
    private String nomEmploye;
    
    @ManyToOne
    @JoinColumn(name = "code_emp_sup")
    private Employe employeSup;
    
    @ManyToMany
    @JoinTable(name = "EMP_GR")
    private Collection<Groupe> groupes;

    public Employe()
    {
    }

    public Employe(String nomEmploye)
    {
        this.nomEmploye = nomEmploye;
    }

    public Long getCodeEmploye()
    {
        return codeEmploye;
    }

    public void setCodeEmploye(Long codeEmploye)
    {
        this.codeEmploye = codeEmploye;
    }

    public String getNomEmploye()
    {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye)
    {
        this.nomEmploye = nomEmploye;
    }
    
    @JsonIgnore
    public Employe getEmployeSup()
    {
        return employeSup;
    }
    
    @JsonSetter
    public void setEmployeSup(Employe employeSup)
    {
        this.employeSup = employeSup;
    }
    
    @JsonIgnore
    public Collection<Groupe> getGroupes()
    {
        return groupes;
    }
    
    @JsonSetter
    public void setGroupes(Collection<Groupe> groupes)
    {
        this.groupes = groupes;
    }
    
    
    
    
}
