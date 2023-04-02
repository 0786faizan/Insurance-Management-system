package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Client;

public interface ClientDao extends JpaRepository<Client,Integer>{

}
