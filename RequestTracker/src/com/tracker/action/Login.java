package com.tracker.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.Gson;
import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.delegate.BusinessDelegate;
import com.tracker.model.User;


public class Login implements SessionAware{

	private SessionMap<String, String> sessionMap=null;
	private String userid;
	private String password;
	DataResult<String> dataResult = null;
	
	public String execute(){
		
		User user = new User();
		
		user.setName(getUserid());
		user.setPassword(getPassword());
		
		String str = (new Gson()).toJson(user);
		System.out.println("str::" + str);
		
		BusinessDelegate bd = new BusinessDelegate();
		bd.setServiceInput(AllConstants.SERVICE_MAIN_USER, AllConstants.SERVICE_METHOD_VALIDATE, str);
		dataResult = bd.doTask();
		
		if(dataResult.isSuccess) {
			
			return "success";
		}
		else	{
			return "failure";
		}
	}
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sessionMap=(SessionMap)map;
		sessionMap.put("login", "true");
		sessionMap.put("profile", dataResult.data);
	}
	
	public void logout(){
		sessionMap.invalidate();
	}

	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
