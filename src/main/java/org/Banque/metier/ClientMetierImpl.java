/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.metier;

import java.util.List;
import org.Banque.dao.ClientRepository;
import org.Banque.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ayoub
 */

@Service
public class ClientMetierImpl implements ClientMetier
{
    @Autowired
    public ClientRepository clientRepository;
    
    @Override
    public Client saveClient(Client c)
    {
        return clientRepository.save(c);
    }

    @Override
    public List<Client> listClient()
    {
        return clientRepository.findAll();
    }
    
    
}
