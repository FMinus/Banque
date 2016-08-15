/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.metier;

import java.io.Serializable;
import java.util.List;
import org.Banque.entities.Operation;

/**
 *
 * @author Ayoub
 */
public class PageOperation implements Serializable
{
    private List<Operation> operations;
    private int page;
    private int nombreOperations;
    private int totalOperations;
    private int totalPages;
    
    
    public List<Operation> getOperations()
    {
        return operations;
    }

    public void setOperations(List<Operation> operations)
    {
        this.operations = operations;
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getNombreOperations()
    {
        return nombreOperations;
    }

    public void setNombreOperations(int nombreOperations)
    {
        this.nombreOperations = nombreOperations;
    }

    public int getTotalOperations()
    {
        return totalOperations;
    }

    public void setTotalOperations(int totalOperations)
    {
        this.totalOperations = totalOperations;
    }

    public int getTotalPages()
    {
        return totalPages;
    }

    public void setTotalPages(int totalPages)
    {
        this.totalPages = totalPages;
    }
    
    
}
