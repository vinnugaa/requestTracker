package com.tracker.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tracker.data.DataResult;
import com.tracker.delegate.BusinessDelegate;

public class SiteEnhanceAction {

	DataResult<String> dataResult = null;

	BusinessDelegate bd = new BusinessDelegate();
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	
	public void add(){
		
	}
}
