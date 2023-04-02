package com.masai.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Claim {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer Claim_Number;
	private String description;
	private LocalDateTime claim_date;
	private String stauts;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ins_number")
	private InsurancePolicy insurancepolicy;
	
	
	public Claim() {
		// TODO Auto-generated constructor stub
	}


	public Integer getClaim_Number() {
		return Claim_Number;
	}


	public void setClaim_Number(Integer claim_Number) {
		Claim_Number = claim_Number;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime getClaim_date() {
		return claim_date;
	}


	public void setClaim_date(LocalDateTime claim_date) {
		this.claim_date = claim_date;
	}


	public String getStauts() {
		return stauts;
	}


	public void setStauts(String stauts) {
		this.stauts = stauts;
	}


	public InsurancePolicy getInsurancepolicy() {
		return insurancepolicy;
	}


	public void setInsurancepolicy(InsurancePolicy insurancepolicy) {
		this.insurancepolicy = insurancepolicy;
	}


	@Override
	public String toString() {
		return "Claim [Claim_Number=" + Claim_Number + ", description=" + description + ", claim_date=" + claim_date
				+ ", stauts=" + stauts + ", insurancepolicy=" + insurancepolicy + "]";
	}


	public Claim(Integer claim_Number, String description, LocalDateTime claim_date, String stauts,
			InsurancePolicy insurancepolicy) {
		super();
		Claim_Number = claim_Number;
		this.description = description;
		this.claim_date = claim_date;
		this.stauts = stauts;
		this.insurancepolicy = insurancepolicy;
	}
	
	
	
	
	
	
	
	
	
	
}
