/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.dao;

import java.io.Serializable;
import org.Banque.entities.Compte;
import org.Banque.entities.Operation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Ayoub
 */
public interface OperationRepository extends JpaRepository<Operation, Long>
{
    @Query("select o from Operation o where o.compte.codeCompte=:x") //: solution general : 1
    public Page<Operation> getOperations(@Param("x") String codeCompte , Pageable pageable);
    
    //public Page<Operation> findByCompte(Compte cp , Pageable pageable); // : 2eme solution
}
