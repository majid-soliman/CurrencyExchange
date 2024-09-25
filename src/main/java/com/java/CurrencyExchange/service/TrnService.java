package com.java.CurrencyExchange.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.java.CurrencyExchange.dao.UsersDAO;
import com.java.CurrencyExchange.ent.UsersEnt;

@Component
public class TrnService {

	
	@Autowired
	ItegrationService integrationService;
	
	@Autowired
	UsersDAO usersDao;
	
	@Autowired
	@Qualifier("employee")
	Transactions trn;
	
	public Map<String , Object> transfare(Map<String, Object> reqMap) throws ClientProtocolException, IOException{
	String josnResult = integrationService.getRequest(reqMap.get("currency").toString());
	JSONObject json = new JSONObject(josnResult);
	double price= json.getDouble("price");
	double amount = Double.parseDouble(reqMap.get("amount").toString());
	
	double result = getTrnType(Integer.parseInt(reqMap.get("userId").toString()))
	.calculate(amount, price);
	
	System.out.println("JSON Result: "+result);
	return Map.of("price",result,"transaction-details",reqMap);
	
	}
	
	public Transactions getTrnType(int id) {
		Transactions trn=null;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		System.out.println(calendar.getTime());
		
		UsersEnt u = usersDao.getUserDetails(id);
	    if(u.getType().equals("employee")) {
	    	trn = new EmployeeTrn();
	     }else if(u.getType().equals("affiliate")) {
	    	 trn = new  AffiliateTrn();
	     }
	    if(u.getCreatedOn().before( calendar.getTime())) {
	    	trn = new OldUserTrn();
	    }
	    
	    return trn;
		
	}
	
	
}
