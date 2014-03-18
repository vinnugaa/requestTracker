package com.tracker.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tracker.cache.TrackerCache;
import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.database.UserDAO;
import com.tracker.model.User;
import com.tracker.utils.Utility;

public class UserService extends BusinessService {

	public UserService(String method, String inputJson) {
		super(method, inputJson);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DataResult<String> doProcessing() {
		// TODO Auto-generated method stub
		DataResult<String> dataResult= null;
		User srcUser = null, destUser = null;
		List<User> allUsers = null;
		UserDAO userDAO = new UserDAO();
		
		srcUser = (User)(new Gson()).fromJson(inputJson, User.class);
		
		if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_VALIDATE)){
			destUser =  userDAO.getUser(srcUser);
			if(destUser != null){
				dataResult = new DataResult<String>();
				dataResult.isSuccess=true;
				dataResult.data = Utility.getInstance().toJson(destUser);
			}
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ADD)){
			userDAO.addUser(srcUser);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			//dataResult.data = Utility.getInstance().toJson(destUser);
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE)){
			userDAO.deleteUser(srcUser);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_UPDATE)){
			userDAO.updateUser(srcUser);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ALL)){
			//CHECK THE CACHE FIRST
			allUsers = (ArrayList<User>)TrackerCache.getInstance().getObject(AllConstants.CACHE_USER_ALL);
			if (allUsers != null) {
				/*dataResult = new DataResult<String>();
				dataResult.data = Utility.getInstance().toJson(allUsers);
				dataResult.isSuccess=true;*/
			}else {
				allUsers = userDAO.getAll();
				TrackerCache.getInstance().addObject(AllConstants.CACHE_USER_ALL, allUsers);
			}
			dataResult = new DataResult<String>();
			dataResult.data = Utility.getInstance().toJson(allUsers);
			dataResult.isSuccess=true;
			
		}
		
		return dataResult;
	}

}
