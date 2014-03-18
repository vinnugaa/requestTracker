package com.tracker.delegate;

import com.tracker.constants.AllConstants;
import com.tracker.service.BusinessService;
import com.tracker.service.DCService;
import com.tracker.service.UserService;

public class BusinessLookUp {

	public BusinessService getBusinessService(String mainService, String method, String inputJson){
		BusinessService businessService = null;
		
		if(mainService.equalsIgnoreCase(AllConstants.SERVICE_MAIN_USER)){
			businessService = new UserService(method, inputJson);
		}else if(mainService.equalsIgnoreCase(AllConstants.SERVICE_MAIN_DC)){
			businessService = new DCService(method, inputJson);
		}
		
		return businessService;
	}
}
