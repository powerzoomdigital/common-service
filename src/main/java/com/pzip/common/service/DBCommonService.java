/**
 * 
 */
package com.pzip.common.service;

import java.sql.Connection;

/**
 * @author Nadeem
 *
 */
public interface DBCommonService {
	public Connection connect(String dbURL,String username, String password);
	
		//Factory Method
		 static DBCommonService createInstance() {
		        return new CommonIPserviceImpl();  // Creating an instance of the implementation class
		 }
}
