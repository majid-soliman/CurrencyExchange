package com.java.CurrencyExchange.service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.CurrencyExchange.ent.*;


public interface UsersRepo extends JpaRepository<UsersEnt, Integer> {

	@Query(value="select id,name,type,created_on from Users u where u.id =:id", nativeQuery=true)
	public UsersEnt getUserDetails(@Param("id") int id );
}
