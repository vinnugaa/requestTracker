package com.tracker.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.delegate.BusinessDelegate;
import com.tracker.model.GenericModel;
import com.tracker.utils.Utility;

public class RequestTypeAction {
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}

	
	
	BusinessDelegate bd = new BusinessDelegate();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	
	public boolean add(GenericModel requestType){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_REQUEST_TYPE, AllConstants.SERVICE_METHOD_ADD, Utility.getInstance().toJson(requestType));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean delete(GenericModel requestType){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_REQUEST_TYPE, AllConstants.SERVICE_METHOD_DELETE, Utility.getInstance().toJson(requestType));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	
	public boolean update(GenericModel requestType){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_REQUEST_TYPE, AllConstants.SERVICE_METHOD_UPDATE, Utility.getInstance().toJson(requestType));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public String getAll(){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_REQUEST_TYPE, AllConstants.SERVICE_METHOD_ALL, AllConstants.EMPTY_STRING);
		dataResult = bd.doTask();
		return dataResult.data;
	}
}
