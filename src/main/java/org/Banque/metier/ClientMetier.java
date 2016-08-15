/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.metier;

import java.util.List;
import org.Banque.entities.Client;

/**
 *
 * @author Ayoub
 */
public interface ClientMetier 
{
    public Client saveClient(Client c);
    public List<Client> listClient();
    
    
}
