package com.masai.service;

import java.util.List;

import com.masai.exception.InsurancePolicyException;
import com.masai.model.InsurancePolicy;

public interface InsuranceServices {

	  public InsurancePolicy saveInsurancePolicy(InsurancePolicy InsurancePolicy);
	  
	  public InsurancePolicy getInsurancePolicyByNumber(Integer number)throws InsurancePolicyException;
	  
	  public List<InsurancePolicy> getAllInsurancePolicyDetails()throws InsurancePolicyException;
	  
	  public InsurancePolicy updateInsurancePolicy(InsurancePolicy InsurancePolicy)throws InsurancePolicyException;
	  
	  public InsurancePolicy deleteInsurancePolicyById(Integer id)throws InsurancePolicyException;

	
}
