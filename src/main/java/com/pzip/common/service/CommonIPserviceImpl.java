package com.pzip.common.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pzip.common.service.ExternalAPIService;
 

public class CommonIPserviceImpl implements DBCommonService, EncryptDecryptService,RuleEngineWrapperService , ExternalAPIService{

	 CommonIPserviceImpl() {
        System.out.println("MyImplementation instance created!");
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
 
        System.out.println("Adhar Card valitation : " + dataValue + " API Response : "+dataValue);
       
    }
	catch(Exception e) {
		System.out.println(e);
	}
		 return dataValue;
	}
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
	public String encrypt(String cipherText) {
		 try {
	            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	            keyGen.init(128);
	            SecretKey secretKey = keyGen.generateKey();
	 
	            Cipher cipher = Cipher.getInstance("AES");
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	            byte[] encryptedBytes = cipher.doFinal(cipherText.getBytes());
	 
	            // Returning the encrypted along with the key for decryption
	            return Base64.getEncoder().encodeToString(encryptedBytes) + ":" + Base64.getEncoder().encodeToString(secretKey.getEncoded());
	        } catch (Exception e) {
	            throw new RuntimeException("Encryption error", e);
	        }
	}
	@Override
	public String decrypt(String cipherText) {
		try {
            // Spliting encryption str and the key
            String[] parts = cipherText.split(":");
            byte[] encryptedBytes = Base64.getDecoder().decode(parts[0]);
            byte[] keyBytes = Base64.getDecoder().decode(parts[1]);
 
            SecretKey secretKey = new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");
 
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Decryption error", e);
        }
	}
	@Override
public Connection connect(String dbURL,String username, String password) {
		
		Connection dbConnect = null;
		
		try
 
	       {
  
	           Class.forName ("com.mysql.cj.jdbc.Driver");
 
	         //  conn = DriverManager.getConnection (url,"apache-tomcat","a1As2Sd3D@");
 
	           dbConnect = DriverManager.getConnection (dbURL,username,password);      
 
	       }
 
	       catch (Exception e)
 
	       {
 
	           e.printStackTrace();
 
	       }
 
	       finally
 
	       {
 
	           if (dbConnect != null)
 
	           {
 
	               try
 
	               {
 
	            	   dbConnect.close ();
 
	                   System.out.println ("Database connection terminated");
 
	               }
 
	               catch (Exception e) { /* ignore close errors */ }
 
	           }
 
	       }
		return dbConnect;
	}
 
	
}
