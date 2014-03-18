package com.tracker.service;

import com.tracker.data.DataResult;

public abstract class BusinessService {
	
	public String inputJson;
	public String method;
	public BusinessService(String method, String inputJson){
		this.inputJson = inputJson;
		this.method = method;
	}
	
	public abstract DataResult<String> doProcessing();
}
