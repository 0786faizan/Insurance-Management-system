package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String date_Of_birth;
	private String address;
	private String contact;
	
   public Client() {
	// TODO Auto-generated constructor stub
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDate_Of_birth() {
	return date_Of_birth;
}

public void setDate_Of_birth(String date_Of_birth) {
	this.date_Of_birth = date_Of_birth;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}

public Client(Integer id, String name, String date_Of_birth, String address, String contact) {
	super();
	this.id = id;
	this.name = name;
	this.date_Of_birth = date_Of_birth;
	this.address = address;
	this.contact = contact;
}

@Override
public String toString() {
	return "Client [id=" + id + ", name=" + name + ", date_Of_birth=" + date_Of_birth + ", address=" + address
			+ ", contact=" + contact + "]";
}
   
   
   
   
   
   
	
}
