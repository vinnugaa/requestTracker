package com.tracker.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.delegate.BusinessDelegate;
import com.tracker.model.DC;
import com.tracker.utils.Utility;

public class DCAction {
	
	private String id;
	private String description;
	private boolean active;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	BusinessDelegate bd = new BusinessDelegate();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	
	public boolean add(DC dc){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_MAIN_DC, AllConstants.SERVICE_METHOD_ADD, Utility.getInstance().toJson(dc));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean delete(DC dc){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_MAIN_DC, AllConstants.SERVICE_METHOD_DELETE, Utility.getInstance().toJson(dc));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean update(DC dc){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_MAIN_DC, AllConstants.SERVICE_METHOD_UPDATE, Utility.getInstance().toJson(dc));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public String getAll(){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_MAIN_DC, AllConstants.SERVICE_METHOD_ALL, AllConstants.EMPTY_STRING);
		dataResult = bd.doTask();
		return dataResult.data;
	}
	

}
