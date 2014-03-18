package com.tracker.delegate;

import com.tracker.data.DataResult;
import com.tracker.service.BusinessService;

public class BusinessDelegate {

	private BusinessLookUp businessLookUp = new BusinessLookUp();
	private BusinessService businessService;
	private String mainService;
	private String subService;
	private String inputJson;

	public void setServiceInput(String mainService, String subService, String inputJson) {
		this.mainService = mainService;
		this.subService = subService;
		this.inputJson = inputJson;
	}
	
	public DataResult<String> doTask(){
		businessService = businessLookUp.getBusinessService(mainService, subService, inputJson);
		return businessService.doProcessing();
	}
}
