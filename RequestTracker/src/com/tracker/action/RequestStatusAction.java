package com.tracker.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.delegate.BusinessDelegate;
import com.tracker.model.RequestStatus;
import com.tracker.utils.Utility;

public class RequestStatusAction {


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
	DataResult<String> dataResult = null;
	
	public String getEach(RequestStatus requestStatus){
		bd.setServiceInput(AllConstants.SERVICE_REQUEST_STATUS, AllConstants.SERVICE_METHOD_EACH, Utility.getInstance().toJson(requestStatus));
		dataResult = bd.doTask();
		return dataResult.data;
	}
	public boolean add(RequestStatus requestStatus){
		bd.setServiceInput(AllConstants.SERVICE_REQUEST_STATUS, AllConstants.SERVICE_METHOD_ADD, Utility.getInstance().toJson(requestStatus));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean delete(RequestStatus requestStatus){
		bd.setServiceInput(AllConstants.SERVICE_REQUEST_STATUS, AllConstants.SERVICE_METHOD_DELETE, Utility.getInstance().toJson(requestStatus));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean update(RequestStatus requestStatus){
		bd.setServiceInput(AllConstants.SERVICE_REQUEST_STATUS, AllConstants.SERVICE_METHOD_UPDATE, Utility.getInstance().toJson(requestStatus));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public String getAll(){
		bd.setServiceInput(AllConstants.SERVICE_REQUEST_STATUS, AllConstants.SERVICE_METHOD_ALL, AllConstants.EMPTY_STRING);
		dataResult = bd.doTask();
		return dataResult.data;
	}
}
	