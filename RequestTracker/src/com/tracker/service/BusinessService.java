package com.tracker.service;

import com.tracker.cache.TrackerCache;
import com.tracker.data.DataResult;

public abstract class BusinessService {
	
	public String inputJson;
	public String method;
	public TrackerCache trackerCache = TrackerCache.getInstance();
	public BusinessService(String method, String inputJson){
		this.inputJson = inputJson;
		this.method = method;
	}
	
	public abstract DataResult<String> doProcessing();
}
