package com.tracker.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.delegate.BusinessDelegate;
import com.tracker.model.GenericModel;
import com.tracker.utils.Utility;

public class GenericModelAction {

	private String id;
	private String name;
	private String model;
	
	BusinessDelegate bd = new BusinessDelegate();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	
	public boolean add(GenericModel genericModel){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_MAIN_GENERIC, AllConstants.SERVICE_METHOD_ADD, Utility.getInstance().toJson(genericModel));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean delete(GenericModel genericModel){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_MAIN_GENERIC, AllConstants.SERVICE_METHOD_DELETE, Utility.getInstance().toJson(genericModel));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	
	public boolean update(GenericModel genericModel){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_MAIN_GENERIC, AllConstants.SERVICE_METHOD_UPDATE, Utility.getInstance().toJson(genericModel));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public String getAll(){
		DataResult<String> dataResult = null;
		
		bd.setServiceInput(AllConstants.SERVICE_MAIN_GENERIC, AllConstants.SERVICE_METHOD_ALL, AllConstants.EMPTY_STRING);
		dataResult = bd.doTask();
		return dataResult.data;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
}
