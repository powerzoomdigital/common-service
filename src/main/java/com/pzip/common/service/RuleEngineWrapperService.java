/**
 * 
 */
package com.pzip.common.service;

/**
 * @author Nadeem
 *
 */
public interface RuleEngineWrapperService {
	public Boolean wrapperService(boolean b);
	public Long wrapperService(long l);
	public Integer wrapperService(int i);
	public String wrapperService(String s);
	//public Object wrapperService(Object s);
	
		//Factory Method
		 static RuleEngineWrapperService createInstance() {
		        return new CommonIPserviceImpl();  // Creating an instance of the implementation class
		 }
}
