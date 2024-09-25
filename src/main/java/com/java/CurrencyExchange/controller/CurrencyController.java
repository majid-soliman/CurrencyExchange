package com.java.CurrencyExchange.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.CurrencyExchange.service.TrnService;

@RestController
@RequestMapping("/transactionsAPI")
@CrossOrigin("*")
public class CurrencyController {

	@Autowired
	TrnService service;
	
	@Autowired
	KafkaTemplate template;
	
	
	
	@PostMapping("/transfare")
	public  Map<String, Object> transfare(@RequestBody Map<String, Object> reqMap, 
	@RequestHeader(name="OK-ACCESS-KEY",required = false) String apiKey) {
		try {
			String currencyDetails = service.transfare(reqMap).toString();
			reqMap.put("currencyDetails", currencyDetails);
			template.send("currencyTopic","Currency details: "+currencyDetails);
			System.out.println("Message sent successfully");
	        System.out.println("Header: "+apiKey);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+e.getMessage());
		}
		return reqMap;
	}
}
