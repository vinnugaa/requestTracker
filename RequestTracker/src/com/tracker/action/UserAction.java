package com.tracker.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.delegate.BusinessDelegate;
import com.tracker.model.User;
import com.tracker.utils.Utility;


public class UserAction {

	private String userList;
	public String getUserList() {
		return userList;
	}
	public void setUserList(String userList) {
		this.userList = userList;
	}
	private String userid;
	private String name;
	private String password;
	private String role;
	
	
	BusinessDelegate bd = new BusinessDelegate();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	
	public boolean add(){
		DataResult<String> dataResult = null;
		User user = new User();
		user.setUserid(getUserid());
		user.setName(getName());
		user.setRole(getRole());
		user.setPassword(getPassword());
		bd.setServiceInput(AllConstants.SERVICE_MAIN_USER, AllConstants.SERVICE_METHOD_ADD, Utility.getInstance().toJson(user));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	
	public boolean delete(){
		DataResult<String> dataResult = null;
		User user = new User();
		user.setUserid(getUserid());
		/*user.setName(getName());
		user.setRole(getRole());
		user.setPassword(getPassword());*/
		bd.setServiceInput(AllConstants.SERVICE_MAIN_USER, AllConstants.SERVICE_METHOD_DELETE, Utility.getInstance().toJson(user));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
	}
	
	public boolean update(){
		DataResult<String> dataResult = null;
		User user = new User();
		user.setUserid(getUserid());
		user.setName(getName());
		user.setRole(getRole());
		user.setPassword(getPassword());
		bd.setServiceInput(AllConstants.SERVICE_MAIN_USER, AllConstants.SERVICE_METHOD_UPDATE, Utility.getInstance().toJson(user));
		dataResult = bd.doTask();
		return dataResult.isSuccess;
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
		return dataResult.data;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
