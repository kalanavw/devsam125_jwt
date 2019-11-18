package  org.sid.demo.service;

import java.util.ArrayList;

import java.util.List;

import org.sid.demo.dao.ClientReposotory;
import org.sid.demo.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository
@Service
public class ClientImp implements ClientService {

	@Autowired
	ClientReposotory clientRep;
	
	@Override
	public Client ajouterClient(Client clt) {
		clientRep.save(clt);
		return null;
	}

	@Override
	public Client supprimerClient(int idClient) {
		clientRep.deleteById(idClient);
		return null;
	}

	@Override
	public Client ModifierClient(Client clt, int id) {
		
		return clientRep.save(clt);
	}

	@Override
	public Page<Client> getListClient(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> AllListClient() {
		

		return	clientRep.findAll();
	
	}

}
