/**
 * 
 */
package com.pzip.common.service;


/**
 * @author Nadeem
 *
 */
public interface ExternalAPIService {
	
	boolean validateAadhaar(String aadhaarNumber);
	//Factory Method
	 static ExternalAPIService createInstance() {
	        return new CommonIPserviceImpl();  // Creating an instance of the implementation class
	    }
}
