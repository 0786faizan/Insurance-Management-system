package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ClaimException;
import com.masai.model.Claim;
import com.masai.repository.ClaimDao;

@Service
public class ClaimServiceImpl implements  ClaimServices{

	@Autowired
	private ClaimDao cdao;
	
	@Override
	public Claim saveClaim(Claim claim) throws ClaimException {
	      Claim cl = cdao.save(claim);
	
	        return cl;
	}

	@Override
	public Claim getClaimByNumber(Integer number) throws ClaimException {
      
		Optional<Claim> opt = cdao.findById(number);

		 if(opt.isPresent())
		 {
			 return opt.get();
			 
		 }else {
			 throw new ClaimException("No claim available...");
		 }
		
	}

	@Override
	public List<Claim> getAllClaimDetails() throws ClaimException {

             List<Claim> claim = cdao.findAll();
             if(claim.size()>0) {
            	 
            	 return claim;
             }
             else {
            	 throw new ClaimException("No claim found...");
             }
		
	}

	@Override
	public Claim updateClaim(Claim claim) throws ClaimException {
       
		    Optional<Claim> opt = cdao.findById(claim.getClaim_Number());
            
		    if(opt.isPresent()) {
		    	
		    	Claim  existclame = opt.get();
		    	
		    return cdao.save(existclame);
		    	
		    }
		    else {
		    	throw new ClaimException("No Claim found...");
		    }
		
	}

	@Override
	public Claim deleteClaimById(Integer id) throws ClaimException {

             Claim claim = cdao.findById(id).orElseThrow(() -> new ClaimException("Invalid data..."));
		
             cdao.delete(claim);
             
             return claim;
	}

}
