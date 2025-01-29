package com.pzip.common.service.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.pzip.common.service.DBCommonService;
import com.pzip.common.service.ExternalAPIService;
import com.pzip.common.service.RuleEngineWrapperService;

public class CommonIPserviceImpl implements DBCommonService, ExternalAPIService, RuleEngineWrapperService{

	 CommonIPserviceImpl()
	{
		
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
	public boolean validateAadhaar(String aadhaarNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
public Connection connect(String dbURL,String username, String password) {
		
		Connection dbConnect = null;
		
		try
 
	       {
 
	         //  String url = "jdbc:mysql://174.141.238.197:3306/innovento_mvp";
 
	    	   //String url = "jdbc:mysql://137.184.210.152:3306/innovento_mvp";
 
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
 
	           if (dbConnect.equals(null))
 
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
