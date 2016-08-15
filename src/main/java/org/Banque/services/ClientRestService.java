/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Banque.services;

import java.util.List;
import org.Banque.entities.Client;
import org.Banque.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ayoub
 */
@RestController
public class ClientRestService 
{
    @Autowired
    private ClientMetier clientMetier;
    
    @RequestMapping(value = "/clients" , method = RequestMethod.POST)
    //@ResponseBody : implicite par : @RestController 
    public Client saveClient(@RequestBody Client c)
    {
        //@RequestBody : indique a spring qu'il doit recuperer les données au corps de la requette : format JSON
        return clientMetier.saveClient(c);
    }
    
    @RequestMapping(value = "/clients" , method = RequestMethod.GET)
    public List<Client> listClient()
    {
        return clientMetier.listClient();
    }
}
