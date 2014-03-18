package com.tracker.service;

import com.tracker.data.DataResult;

public abstract class BusinessService {
	
	public String inputJson;
	public BusinessService(String inputJson){
		this.inputJson = inputJson;
	}
	
	public abstract DataResult<String> doProcessing();
}
