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
	public Connection connect(String username, String password);
	
	
}
