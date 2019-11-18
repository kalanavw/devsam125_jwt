 package org.sid.demo.service;
 
import java.util.List;

import org.sid.demo.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

public interface ClientService {

	Client ajouterClient(Client clt);

	Client supprimerClient(int idClient );
	
	Client ModifierClient(Client clt, int id);
	
	Page<Client> getListClient(int page, int size);
	List<Client> AllListClient();
	
}
