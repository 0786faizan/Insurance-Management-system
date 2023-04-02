package com.masai.service;

import java.util.List;

import com.masai.exception.ClaimException;
import com.masai.exception.InsurancePolicyException;
import com.masai.model.Claim;
import com.masai.model.InsurancePolicy;

public interface ClaimServices {

	public Claim saveClaim(Claim claim)throws ClaimException;
	
	public Claim getClaimByNumber(Integer number)throws ClaimException;
	
	public List<Claim> getAllClaimDetails() throws ClaimException;
	
	public Claim updateClaim(Claim claim) throws ClaimException;
	
	public Claim deleteClaimById(Integer id) throws ClaimException;
	
	
	
}

