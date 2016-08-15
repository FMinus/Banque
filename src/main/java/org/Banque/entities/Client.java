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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ayoub
 */
@Entity
public class Client implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CodeClient;
    private String nomClient;
    
    //Lazy : pas charger si non requis
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private Collection<Compte> comptes;

    public Client()
    {
        super();
    }

    public Client(String nomClient)
    {
        super();
        this.nomClient = nomClient;
    }
    
    
    public Client(Long CodeClient, String nomClient, Collection<Compte> comptes)
    {
        this.CodeClient = CodeClient;
        this.nomClient = nomClient;
        this.comptes = comptes;
    }

    public Long getCodeClient()
    {
        return CodeClient;
    }

    public void setCodeClient(Long CodeClient)
    {
        this.CodeClient = CodeClient;
    }

    public String getNomClient()
    {
        return nomClient;
    }

    public void setNomClient(String nomClient)
    {
        this.nomClient = nomClient;
    }
    
    @JsonIgnore
    @XmlTransient
    public Collection<Compte> getComptes()
    {
        return comptes;
    }
    
    //@JsonSetter
    public void setComptes(Collection<Compte> comptes)
    {
        this.comptes = comptes;
    }
    
    
}
