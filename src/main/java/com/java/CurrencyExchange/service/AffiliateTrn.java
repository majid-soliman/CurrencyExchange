package com.java.CurrencyExchange.service;

import org.springframework.stereotype.Component;

@Component("affiliate")
public class AffiliateTrn implements Transactions {

	@Override
	public double calculate(double amount,double price) {
		double trnFees = 50;
		double discount = trnFees/100*10;
		trnFees = trnFees -discount; 
		return  amount * price +trnFees;
	}

}
