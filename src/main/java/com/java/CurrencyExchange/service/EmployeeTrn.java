package com.java.CurrencyExchange.service;

import org.springframework.stereotype.Component;

@Component("employee")
public class EmployeeTrn implements Transactions {

	@Override
	public double calculate(double amount, double price) {
		double trnFees = 50;
		double discount = trnFees/100*30;
		trnFees = trnFees -discount; 
		return  amount * price +trnFees;
	}
	

}
