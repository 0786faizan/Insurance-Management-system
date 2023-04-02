package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.InsurancePolicyException;
import com.masai.model.InsurancePolicy;
import com.masai.service.InsuranceServices;

@RestController
public class InsuranceController {

	@Autowired
	private InsuranceServices iservice;
	
	@PostMapping("/Insurance")
	public ResponseEntity<InsurancePolicy> saveInsurancePolicyHandler(@RequestBody InsurancePolicy insurancepoliy) {

        InsurancePolicy ipo = iservice.saveInsurancePolicy(insurancepoliy);
        
        return new ResponseEntity<InsurancePolicy>(ipo,HttpStatus.OK);
	}
	
	@GetMapping("/Insurance/{number}")
	public ResponseEntity<InsurancePolicy> getInsurancePolicyByIdHandler(@PathVariable("number")Integer number)throws InsurancePolicyException{
		 InsurancePolicy ipo = iservice.getInsurancePolicyByNumber(number);
	        
	        return new ResponseEntity<InsurancePolicy>(ipo,HttpStatus.OK);
	}
	
	@GetMapping("/insurance")
	public ResponseEntity<List<InsurancePolicy>> getAllInsurancePolicyHandler()
	{
		 List<InsurancePolicy> ipo = iservice.getAllInsurancePolicyDetails();
		 
		 return new ResponseEntity<List<InsurancePolicy>>(ipo,HttpStatus.OK);
	}
	
	@PutMapping("/insurance")
	public ResponseEntity<InsurancePolicy> UpdateInsuranceDataHandler(@RequestBody InsurancePolicy insurancepolicy)throws InsurancePolicyException{
		 
		InsurancePolicy ipo = iservice.updateInsurancePolicy(insurancepolicy);
		
		return new ResponseEntity<InsurancePolicy>(ipo,HttpStatus.OK);
		
	}
	
	@DeleteMapping("insurance/{number}")
	public ResponseEntity<InsurancePolicy> DeleteInsuranceHandler(@PathVariable("number") Integer number)throws InsurancePolicyException{
		  
		InsurancePolicy ipo = iservice.deleteInsurancePolicyById(number);
		
		return new  ResponseEntity<InsurancePolicy>(ipo,HttpStatus.OK);
		
		
	}
}
