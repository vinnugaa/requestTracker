package com.tracker.delegate;

import com.tracker.constants.AllConstants;
import com.tracker.service.BusinessService;
import com.tracker.service.DCService;
import com.tracker.service.DatabaseTableService;
import com.tracker.service.MarketService;
import com.tracker.service.RequestStatusService;
import com.tracker.service.SiteEnhanceService;
import com.tracker.service.UserService;
import com.tracker.service.WorkLogService;

public class BusinessLookUp {

	public BusinessService getBusinessService(String mainService, String method, String inputJson){
		BusinessService businessService = null;
		
		if(mainService.equalsIgnoreCase(AllConstants.SERVICE_MAIN_USER)){
			businessService = new UserService(method, inputJson);
		}else if(mainService.equalsIgnoreCase(AllConstants.SERVICE_MAIN_DC)){
			businessService = new DCService(method, inputJson);
		}else if(mainService.equalsIgnoreCase(AllConstants.SERVICE_MAIN_TABLES)){
			businessService = new DatabaseTableService(method, inputJson);
		}else if(mainService.equalsIgnoreCase(AllConstants.SERVICE_MAIN_SITE_ENHANCER)){
			businessService = new SiteEnhanceService(method, inputJson);
		}else if(mainService.equalsIgnoreCase(AllConstants.SERVICE_MAIN_MARKET)){
			businessService = new MarketService(method, inputJson);
		}else if(mainService.equalsIgnoreCase(AllConstants.SERVICE_MAIN_WORK_LOG)){
			businessService = new WorkLogService(method, inputJson);
		}else if(mainService.equalsIgnoreCase(AllConstants.SERVICE_MAIN_REQUEST_TYPE)){
			businessService = new RequestStatusService(method, inputJson);
		}else if(mainService.equalsIgnoreCase(AllConstants.SERVICE_MAIN_REQUEST_STATUS)){
			businessService = new MarketService(method, inputJson);
		}else if(mainService.equalsIgnoreCase(AllConstants.SERVICE_MAIN_GENERIC)){
			businessService = new MarketService(method, inputJson);
		}
		
		return businessService;
	}
}
