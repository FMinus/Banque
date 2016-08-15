/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.metier;

import java.util.List;
import org.Banque.dao.EmployeRepository;
import org.Banque.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ayoub
 */
@Service
public class EmployeMetierImpl implements EmployeMetier
{
    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Employe save(Employe e)
    {
        return employeRepository.save(e);
    }

    @Override
    public List<Employe> listEmployes()
    {
        return employeRepository.findAll();
    }
    
    
}
