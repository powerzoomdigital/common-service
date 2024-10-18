package com.pzip.common.serviceImpl;

import java.io.IOException;
import java.sql.Connection;
import com.pzip.common.service.DBCommonService;
import com.pzip.common.service.EncryptDecryptService;
import com.pzip.common.service.ExternalAPIService;
import com.pzip.common.service.RuleEngineWrapperService;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
 

public class CommonIPserviceImpl implements EncryptDecryptService, DBCommonService, RuleEngineWrapperService, ExternalAPIService{

	@Override
	public Boolean wrapperService(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long wrapperService(long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer wrapperService(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String wrapperService(String s) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String encrypt(String algorithm, String cipherText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String algorithm, String cipherText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection connect(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateAadhaar(String aadhaarNumber)  {
		boolean dataValue =false;
		String bodyContent = "{ \"aadhaar\": \"" + aadhaarNumber + "\"}";
		 try {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.apyhub.com/validate/aadhaar"))
            .header("Content-Type", "application/json")
            .header("apy-token", "APY0Sk5wP0mEAuDsLtr0rk8uYTuizkjmAqhPhotEiXkOy95xDdOeOixXjpJk8TcqUQ8qkzk")
            .POST(HttpRequest.BodyPublishers.ofString(bodyContent))
            .build();
 
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
 
        System.out.println(response.body());
        System.out.println(response.statusCode());
 
        // Parse JSON
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.body());
 
        // Extract the value of "data"
         dataValue = rootNode.path("data").asBoolean();
 
        System.out.println("Data: " + dataValue);
       
    }
	catch(Exception e) {
		System.out.println(e);
	}
		 return dataValue;
	}
}
