package com.java.CurrencyExchange.service;

import org.springframework.stereotype.Component;

@Component("oldUser")
public class OldUserTrn implements Transactions{

	@Override
	public double calculate(double amount, double price) {
		double trnFees = 50;
		double discount = trnFees/100*5;
		trnFees = trnFees -discount; 
		return  amount * price +trnFees;
	}

}
