package com.java.CurrencyExchange.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.CurrencyExchange.ent.UsersEnt;
import com.java.CurrencyExchange.service.UsersRepo;

@Component
public class UsersDAO {

	@Autowired
	UsersRepo repo;
	
	public UsersEnt getUserDetails(int id) {
		return repo.getUserDetails(id);
	}
}
