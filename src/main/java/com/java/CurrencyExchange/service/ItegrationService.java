package com.java.CurrencyExchange.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ItegrationService {

public static CloseableHttpClient client = HttpClients.createDefault();
	
//	public static void main(String args[]) throws ClientProtocolException, IOException {
//		getRequest();
//	}
	
	public static String getRequest(String currency) throws ClientProtocolException, IOException {
		HttpPost post = new HttpPost("http://localhost:8083/currencyAPI/getCurrencyPrice");
		JSONObject json = new JSONObject();
		json.put("name","King Soliman");
		json.put("currency",currency);
		
		StringEntity s = new StringEntity(json.toString(),"UTF-8");
		s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		post.setEntity(s);
		
		  post.setHeader("Content-Type", "application/json");
		  post.addHeader("OK-ACCESS-KEY","Api-Key");
	     
		
		CloseableHttpResponse response = client.execute(post);
		HttpEntity entity = response.getEntity();
		String result = null;
		if(entity!=null) {
		    result = EntityUtils.toString(entity);
			System.out.println("Result: "+result);
		}
		
		return result;
	
	}
}
