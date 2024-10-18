/**
 * 
 */
package com.pzip.common.service.util;

import com.pzip.common.service.DBCommonService;
import com.pzip.common.service.EncryptDecryptService;
import com.pzip.common.service.ExternalAPIService;
import com.pzip.common.serviceImpl.CommonIPserviceImpl;

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
		
		DBCommonService dbservice=new CommonIPserviceImpl();
		dbservice.connect(null, null);
		
		EncryptDecryptService encreypt= new CommonIPserviceImpl();
		encreypt.decrypt(null, null);
		
		ExternalAPIService apiservice=new CommonIPserviceImpl();
		
			System.out.println("Output from API : "+ apiservice.validateAadhaar("667125001525"));
		

	}

}
