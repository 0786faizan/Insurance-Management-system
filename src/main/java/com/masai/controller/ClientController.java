package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ClientException;
import com.masai.model.Client;
import com.masai.service.ClientService;

@RestController
public class ClientController {
    
	@Autowired
	private ClientService cservice;
	
	@PostMapping("/client")
	public ResponseEntity<Client> saveClientHandler(@RequestBody Client client){
		
		Client client1 = cservice.saveClient(client);
		
		return new ResponseEntity<Client>(client1,HttpStatus.OK);
	}
	
	
	@GetMapping("/client/{id}")
	public ResponseEntity<Client> getCleintByIdHandler(@PathVariable("id") Integer id)throws ClientException	{
		 Client client = cservice.getClientById(id);
		 
		 return new ResponseEntity<Client>(client,HttpStatus.OK);
	}
	
	@GetMapping("/client")
	public ResponseEntity<List<Client>> getAllClientHandler(){
		List<Client> client = cservice.getAllClientDetails();
		
		return new ResponseEntity<List<Client>>(client,HttpStatus.OK);
		
	}
	
	@PutMapping("/client")
	public ResponseEntity<Client> UpdateClientHandler(@RequestBody Client client)throws ClientException {
		
		Client client1 =  cservice.updateClient(client);
		return new ResponseEntity<Client>(client1,HttpStatus.OK);
	}
	
	@DeleteMapping("/client/{id}")
	public ResponseEntity<Client> DeleteClientHandler(@PathVariable("id") Integer id)throws ClientException
	{
		Client client = cservice.deleteClientById(id);
		
		return new ResponseEntity<Client>(client,HttpStatus.OK);
	}
}


//
//@PutMapping("/students/{roll}")
//	public ResponseEntity<Student> updateStudentMarksHandler(@PathVariable("roll")Integer roll,@RequestParam("m")Integer gMarks){
//		
//		 Student updateStudent = sSerivce.updateStudentMarks(roll, gMarks);
//		 
//		 return new ResponseEntity<Student>(updateStudent,HttpStatus.OK);
		 