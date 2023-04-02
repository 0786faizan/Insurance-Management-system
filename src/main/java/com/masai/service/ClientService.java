package com.masai.service;

import java.util.List;

import com.masai.exception.ClientException;
import com.masai.model.Client;

public interface ClientService {

  public Client saveClient(Client client);
  
  public Client getClientById(Integer id)throws ClientException;
  
  public List<Client> getAllClientDetails()throws ClientException;
  
  public Client updateClient(Client client)throws ClientException;
  
  public Client deleteClientById(Integer id)throws ClientException;
  
	
	
	

	
}
