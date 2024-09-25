package com.java.CurrencyExchange.ent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currencies")
//@AllArgsConstrcutor
public class CurrenciesEnt {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String currency;
	private double price;
	
	public CurrenciesEnt(String currency, double price) {
		this.currency = currency;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
