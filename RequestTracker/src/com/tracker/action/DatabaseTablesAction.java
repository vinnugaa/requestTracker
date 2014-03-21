package com.tracker.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.delegate.BusinessDelegate;

public class DatabaseTablesAction {

	private String tableName;
	DataResult<String> dataResult = null;

	BusinessDelegate bd = new BusinessDelegate();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	
	public String getAll() {
		bd.setServiceInput(AllConstants.SERVICE_MAIN_TABLES, AllConstants.SERVICE_METHOD_ALL, getTableName());
		dataResult = bd.doTask();
		return dataResult.data;
	}
	public boolean purgeEach() {
		bd.setServiceInput(AllConstants.SERVICE_MAIN_TABLES, AllConstants.SERVICE_METHOD_PURGE_EACH, getTableName());
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean purgeAll() {
		bd.setServiceInput(AllConstants.SERVICE_MAIN_TABLES, AllConstants.SERVICE_METHOD_PURGE_ALL, getTableName());
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean delete(){
		bd.setServiceInput(AllConstants.SERVICE_MAIN_TABLES, AllConstants.SERVICE_METHOD_DELETE, getTableName());
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean deleteAll(){
		bd.setServiceInput(AllConstants.SERVICE_MAIN_TABLES, AllConstants.SERVICE_METHOD_DELETE_ALL, getTableName());
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean create(){
		bd.setServiceInput(AllConstants.SERVICE_MAIN_TABLES, AllConstants.SERVICE_METHOD_CREATE, getTableName());
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	public boolean createAll(){
		bd.setServiceInput(AllConstants.SERVICE_MAIN_TABLES, AllConstants.SERVICE_METHOD_CREATE_ALL, getTableName());
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
}
