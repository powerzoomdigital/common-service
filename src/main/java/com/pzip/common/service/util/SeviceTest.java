/**
 * 
 */
package com.pzip.common.service.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.pzip.common.service.DBCommonService;

/**
 * @author Nadeem
 *
 */
public class SeviceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
		String dbURL = "jdbc:mysql://newaikyadb.mysql.database.azure.com/aikyadb";
		String username = "aikya";
		String password = "Champi0n335577";
 
		DBCommonService dbservice = new CommonIPserviceImpl();
 
		 conn = dbservice.connect(dbURL, username, password);
 
	
 
		//	System.out.println("Database connection established");
			// Creating a Statement object
			Statement stmt = conn.createStatement();
			// Retrieving the data
			ResultSet rs = stmt.executeQuery("Show Databases");
			System.out.println("List of databases: ");
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("Database connection terminated");
				} catch (Exception e) {
					/* ignore close errors */ }
			}
		}
	}
 
}