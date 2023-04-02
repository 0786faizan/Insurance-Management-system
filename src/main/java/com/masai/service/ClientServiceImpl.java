package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ClientException;
import com.masai.model.Client;
import com.masai.repository.ClaimDao;
import com.masai.repository.ClientDao;
import com.masai.repository.InsuranceDao;

@Service
public class ClientServiceImpl implements ClientService{

	
	@Autowired
	private ClientDao cdao;	
	
	@Override
	public Client saveClient(Client client) {
		
		Client client1 = cdao.save(client);
		
		return client1;
	}

	@Override
	public Client getClientById(Integer id) throws ClientException {
     
	 Optional<Client> opt = cdao.findById(id);

	  if(opt.isPresent())
	  {
		 return opt.get();
		  
	  }
	  else {
		  throw new ClientException("Client is not available with this id:"+id);
	  }		
	}

	@Override
	public List<Client> getAllClientDetails() throws ClientException {

             List<Client> client = cdao.findAll();
             
             if(client.size()>0)
             {
            	 return client;
             }
             else {
            	 throw new ClientException("No Client Avaible....");
             }
		
		
		
	}

	@Override
	public Client updateClient(Client client) throws ClientException {
		    
		   Optional<Client> opt = cdao.findById(client.getId());
		
		   
		  if(opt.isPresent()) {
			  
			  Client existClient = opt.get();
			  return cdao.save(existClient);
			  
		  }
		  else {
			  throw new ClientException("Invalid Client details...");
		  }
		   
		   
		   
	}

	@Override
	public Client deleteClientById(Integer id) throws ClientException {
		Client existclient = cdao.findById(id).orElseThrow(() -> new ClientException("student doest not exist"));
		 cdao.delete(existclient);
		
		 return existclient;

	}

}
