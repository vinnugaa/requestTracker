package com.tracker.delegate;

import com.tracker.data.DataResult;
import com.tracker.service.BusinessService;

public class BusinessDelegate {

	private BusinessLookUp businessLookUp = new BusinessLookUp();
	private BusinessService businessService;
	private String serviceType;
	private String inputJson;

	public void setServiceInput(String serviceType, String inputJson) {
		this.serviceType = serviceType;
		this.inputJson = inputJson;
	}
	
	public DataResult<String> doTask(){
		businessService = businessLookUp.getBusinessService(serviceType, inputJson);
		return businessService.doProcessing();
	}
}
