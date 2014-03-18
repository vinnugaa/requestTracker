package com.tracker.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

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
		bd.setServiceInput("ADD_USER", Utility.getInstance().toJson(user));
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
		bd.setServiceInput("DELETE_USER", Utility.getInstance().toJson(user));
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
		bd.setServiceInput("UPDATE_USER", Utility.getInstance().toJson(user));
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
		bd.setServiceInput("ALL_USER", "");
		dataResult = bd.doTask();
		return dataResult.data;
	}
	
	/*
	public String add(){
		String result = "failure";
		User user = new User();
		user = (User)Utility.getInstance().reflector(this, user);
		UserDB.getInstance().addUser(user);
		result = "success";
		return result;
	}
	
	public String delete(){
		String result = "failure";
		User user = new User();
		user = (User)Utility.getInstance().reflector(this, user);
		UserDB.getInstance().deleteUser(user);
		result = "success";
		return result;
	}
	
	public String update(){
		String result="failure";
		User user = new User();
		user = (User)Utility.getInstance().reflector(this, user);
		UserDB.getInstance().updateUser(user);	
		result = "success";
		return result;
	}
	public String listAll(){
		String users = "";
		users = UserDB.getInstance().listUsers();
		setUserList(users);
		return "success";
	}
	*/
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
