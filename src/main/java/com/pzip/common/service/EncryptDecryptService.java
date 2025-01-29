/**
 * 
 */
package com.pzip.common.service;

/**
 * @author Nadeem
 *
 */
public interface EncryptDecryptService {
	public String encrypt(String cipherText);
	public String decrypt(String cipherText);
	
	//Factory Method
	 static EncryptDecryptService createInstance() {
	        return new CommonIPserviceImpl();  // Creating an instance of the implementation class
	 }
}
