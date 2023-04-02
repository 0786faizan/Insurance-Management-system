package com.masai.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class InsurancePolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer number;
	private String type;
	private String coverage;
	private Integer amount;
	private String premium;
	private LocalDateTime start_date;
	private LocalDateTime end_date;
	
	@OneToMany(mappedBy="insurancepolicy", cascade=CascadeType.ALL)
	private List<Claim> claim;
 
	public InsurancePolicy() {
		// TODO Auto-generated constructor stub
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public LocalDateTime getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}

	public LocalDateTime getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDateTime end_date) {
		this.end_date = end_date;
	}

	public List<Claim> getClaim() {
		return claim;
	}

	public void setClaim(List<Claim> claim) {
		this.claim = claim;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [number=" + number + ", type=" + type + ", coverage=" + coverage + ", amount=" + amount
				+ ", premium=" + premium + ", start_date=" + start_date + ", end_date=" + end_date + ", claim=" + claim
				+ "]";
	}

	public InsurancePolicy(Integer number, String type, String coverage, Integer amount, String premium,
			LocalDateTime start_date, LocalDateTime end_date, List<Claim> claim) {
		super();
		this.number = number;
		this.type = type;
		this.coverage = coverage;
		this.amount = amount;
		this.premium = premium;
		this.start_date = start_date;
		this.end_date = end_date;
		this.claim = claim;
	}

	


}
