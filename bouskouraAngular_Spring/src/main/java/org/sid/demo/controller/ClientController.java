package org.sid.demo.controller;

import java.util.List;

import org.sid.demo.entities.Client;
import org.sid.demo.entities.Produit;
import org.sid.demo.service.ClientImp;
import org.sid.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ClientController {
	@Autowired
	ClientService clientser1;
	
	
	@RequestMapping(path = "/LClient", method = RequestMethod.GET)
	public List<Client> listClient() {
			
		return clientser1.AllListClient();
		
	}
	

	@RequestMapping(value="/AjouterClient",method= RequestMethod.POST )	
    public Client createEmployee( @RequestBody Client clt) {
        return clientser1.ajouterClient(clt);
    }

}
