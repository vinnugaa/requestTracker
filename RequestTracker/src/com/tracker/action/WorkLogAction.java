package com.tracker.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.delegate.BusinessDelegate;
import com.tracker.model.User;
import com.tracker.model.WorkLog;
import com.tracker.utils.Utility;

public class WorkLogAction {

	private String id;
	private String requestId;
	private String date;
	private String log;
	
	BusinessDelegate bd = new BusinessDelegate();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	
	public String add(){
		DataResult<String> dataResult = null;
		WorkLog workLog = new WorkLog();
		workLog.setDate(getDate());
		workLog.setId(getId());
		workLog.setLog(getLog());
		workLog.setRequestId(getRequestId());
		
		bd.setServiceInput(AllConstants.SERVICE_WORK_LOG, AllConstants.SERVICE_METHOD_ADD, Utility.getInstance().toJson(workLog));
		dataResult = bd.doTask();
		return getResult(dataResult.isSuccess);
	}
	
	public String delete(){
		DataResult<String> dataResult = null;
		User user = new User();/*
		user.setUserid(getUserid());
		/*user.setName(getName());
		user.setRole(getRole());
		user.setPassword(getPassword());*/
		bd.setServiceInput(AllConstants.SERVICE_MAIN_USER, AllConstants.SERVICE_METHOD_DELETE, Utility.getInstance().toJson(user));
		dataResult = bd.doTask();
		return getResult(dataResult.isSuccess);
	}
	
	public String update(){
		DataResult<String> dataResult = null;
		User user = new User();/*
		user.setUserid(getUserid());
		user.setName(getName());
		user.setRole(getRole());
		user.setPassword(getPassword());*/
		bd.setServiceInput(AllConstants.SERVICE_MAIN_USER, AllConstants.SERVICE_METHOD_UPDATE, Utility.getInstance().toJson(user));
		dataResult = bd.doTask();
		return getResult(dataResult.isSuccess);
	}
	
	public String getAll(){
		DataResult<String> dataResult = null;
		/*User user = new User();
		user.setUserid(getUserid());
		user.setName(getName());
		user.setRole(getRole());
		user.setPassword(getPassword());*/
		bd.setServiceInput(AllConstants.SERVICE_MAIN_USER, AllConstants.SERVICE_METHOD_ALL, AllConstants.EMPTY_STRING);
		dataResult = bd.doTask();
		System.out.println("dataResult.data:: "+ dataResult.data);
		// TODO:: Uncomment the below statement
		//return dataResult.data;
		return "success";
	}
	
	public String getResult(boolean result){
		String res = "failure";
		if(result) return "success";
		return res;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}	
	
}
