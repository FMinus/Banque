/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Ayoub
 */
@Entity
@DiscriminatorValue("R")
@XmlType(name = "R")
public class Retrait extends Operation
{
    
}
