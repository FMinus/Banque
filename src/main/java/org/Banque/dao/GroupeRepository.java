/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.dao;

import java.io.Serializable;
import org.Banque.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ayoub
 */
public interface GroupeRepository extends JpaRepository<Groupe, Long>
{
    
}
