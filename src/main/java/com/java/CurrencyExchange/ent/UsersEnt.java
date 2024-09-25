package com.java.CurrencyExchange.ent;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UsersEnt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String type;
    
	@Column(name="created_on")
	private Date createdOn;
	
	public UsersEnt() {
		
	}
	
	public UsersEnt(int id,String name, String type,Date createdOn) {
	 this.id = id;
	 this.name = name;
	 this.type = type;
	 this.createdOn = createdOn;
	 
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOne(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
}
