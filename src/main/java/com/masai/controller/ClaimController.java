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
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.ClientException;
import com.masai.model.Claim;
import com.masai.service.ClaimServices;

@RestController
public class ClaimController {

	@Autowired
	private ClaimServices cservices;
	
	@PostMapping("/claim")
	public ResponseEntity<Claim> saveClaimHandler(@RequestBody Claim claim){
		
		Claim clam = cservices.saveClaim(claim);
		
		return new ResponseEntity<Claim>(clam,HttpStatus.OK);
	}
	
	@GetMapping("/claim/{number}")	
	public ResponseEntity<Claim> getclaimByNumberHandler(@PathVariable("number")Integer number)throws ClientException{
		Claim clame = cservices.getClaimByNumber(number);
		return new ResponseEntity<Claim>(clame,HttpStatus.OK);
	}
	
	@GetMapping("/claim")
	public ResponseEntity<List<Claim>> getAllClaimHandler(){
		List<Claim> clame = cservices.getAllClaimDetails();
		
		return new ResponseEntity<List<Claim>>(clame,HttpStatus.OK);
	}
	
	
	@PutMapping("/claim")
	public ResponseEntity<Claim> UpdateclaimHandler(@RequestBody Claim claim)throws ClientException{
		
		Claim clame = cservices.updateClaim(claim);
		
		return new ResponseEntity<Claim>(clame,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/claim/{number}")
	public ResponseEntity<Claim> DeleteClaimHandler(@PathVariable("number")Integer number)throws ClientException{
		
		Claim clame =  cservices.deleteClaimById(number);
		
		return new ResponseEntity<Claim>(clame,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
