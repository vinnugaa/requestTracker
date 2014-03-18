package com.tracker.service;

import com.google.gson.Gson;
import com.tracker.data.DataResult;
import com.tracker.database.UserDAO;
import com.tracker.model.User;

public class LoginValidate extends BusinessService {


	public LoginValidate(String inputJson) {
		super(inputJson);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DataResult<String> doProcessing() {
		// TODO Auto-generated method stub
		DataResult<String> dataResult= new DataResult<String>();
		dataResult.isSuccess=true;
		System.out.println(inputJson);
		
		User inputUser = (User)(new Gson()).fromJson(inputJson, User.class);
		UserDAO userDAO = new UserDAO();
		userDAO.listUsers();
		
		User resultUser = userDAO.getUser(inputUser);
		if(resultUser!= null) {
			dataResult.isSuccess = true;
			dataResult.data = (new Gson()).toJson(resultUser);
		}
		
		return dataResult;
	}
	


}
