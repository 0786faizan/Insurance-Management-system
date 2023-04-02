package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.InsurancePolicyException;
import com.masai.model.InsurancePolicy;
import com.masai.repository.InsuranceDao;

@Service
public class InsuranceServicesImpl implements InsuranceServices {

	@Autowired
	private InsuranceDao idao;
	@Override
	public InsurancePolicy saveInsurancePolicy(InsurancePolicy InsurancePolicy) {
          
		    InsurancePolicy ipo = idao.save(InsurancePolicy);

		     return ipo;
		
	}

	@Override
	public InsurancePolicy getInsurancePolicyByNumber(Integer number) throws InsurancePolicyException {
		
		      Optional<InsurancePolicy> opt = idao.findById(number);
		   
		      if(opt.isPresent())
		      {  
		    	  return opt.get();
		    	  
		      }
		      else {
		    	  throw new InsurancePolicyException("No policy is available...");
		      }    
		      
	}

	@Override
	public List<InsurancePolicy> getAllInsurancePolicyDetails() throws InsurancePolicyException {
		
		   List<InsurancePolicy> insurance = idao.findAll();
		   
		   if(insurance.size()>0) {
			   return insurance;
		   }
		   else {
			   throw new InsurancePolicyException("No policy is there...");
		   }
		     
		
	}

	@Override
	public InsurancePolicy updateInsurancePolicy(InsurancePolicy InsurancePolicy) throws InsurancePolicyException {
		
		       Optional<InsurancePolicy> opt =  idao.findById(InsurancePolicy.getNumber());
		
		        
		     if(opt.isPresent())
		     {
		    	 InsurancePolicy ipo = opt.get();
		    	 
		    	 return idao.save(ipo);
		     }
		     else {
		    	 throw new InsurancePolicyException("please provide valid data...");
		     }
		
		
		
	}

	@Override
	public InsurancePolicy deleteInsurancePolicyById(Integer id) throws InsurancePolicyException {

               InsurancePolicy insurancepolicy = idao.findById(id).orElseThrow(() -> new InsurancePolicyException("No Policy found.."));
		
               idao.delete(insurancepolicy);;
               
               return insurancepolicy;
	}

}
