package com.tracker.action;

import com.tracker.delegate.BusinessDelegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.delegate.BusinessDelegate;
import com.tracker.model.DC;
import com.tracker.utils.Utility;

public class MarketAction {
	
	private String id;
	private String countryName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getcountryName() {
		return countryName;
	}
	public void setcountryName(String countryName) {
		this.countryName = countryName;
	}

	
	
	BusinessDelegate bd = new BusinessDelegate();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	
	public boolean add(Market countryName){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_MAIN_MARKET, AllConstants.SERVICE_METHOD_ADD, Utility.getInstance().toJson(dc));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean delete(Market countryName){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_MAIN_MARKET, AllConstants.SERVICE_METHOD_DELETE, Utility.getInstance().toJson(dc));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	//
	public boolean update(Market countryName){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_MAIN_MARKET, AllConstants.SERVICE_METHOD_UPDATE, Utility.getInstance().toJson(dc));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public String getAll(){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_MAIN_MARKET, AllConstants.SERVICE_METHOD_ALL, AllConstants.EMPTY_STRING);
		dataResult = bd.doTask();
		return dataResult.data;
	}

}
