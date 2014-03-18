package com.tracker.delegate;

import com.tracker.service.BusinessService;
import com.tracker.service.LoginValidate;

public class BusinessLookUp {

	public BusinessService getBusinessService(String serviceType, String inputJson){
		BusinessService businessService = null;
		
		if(serviceType.equalsIgnoreCase("VALIDATE_LOGIN")){
			return new LoginValidate(inputJson);
		}else if(serviceType.equalsIgnoreCase("USER_DETAILS")){
			
		}//else if(serviceType.equalsIgnoreCase(anotherString))
		
		return businessService;
	}
}
