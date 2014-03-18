package com.tracker.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tracker.constants.AllConstants;
import com.tracker.model.User;

public class UserDAO {

	public User getUser(User user){
		User resultUser = null;
		try {
			String command = "SELECT * FROM " + AllConstants.DATABASE_TABLE_USER
					+ " WHERE " + AllConstants.USERID + "='"+user.getUserid()+"' ";
			ResultSet rs = DBUtils.getInstance().query(command);
			while(rs.next()){
				resultUser = new User();
				resultUser.setUserid(rs.getString(AllConstants.USERID));
				resultUser.setName(rs.getString(AllConstants.NAME));
				resultUser.setRole(rs.getString(AllConstants.ROLE));
				resultUser.setPassword(rs.getString(AllConstants.PASSWORD));
			}
			if(resultUser!=null && resultUser.getPassword().equals(user.getPassword())){
				return resultUser;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public void addUser(User user){
		try{
			//update("INSERT INTO " + tableName + "(name,password) VALUES('"+ username + "','"+ password + "')");
			String command = "INSERT INTO "+ AllConstants.DATABASE_TABLE_USER 
					+ " VALUES ( " 
					+ user.getUserid() + ",'"
					+ user.getName() + "','"
					+ user.getRole() +  "','"
					+ user.getPassword()
					+ "' )" ;
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void deleteUser(User user){
		try {
			String command= "DELETE FROM "+ AllConstants.DATABASE_TABLE_USER
					+ " WHERE " + AllConstants.USERID + "="+user.getUserid();
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<User> listUsers(){
		ResultSet rs= null;
		List<User> userList = null;
		User user;
		
		try{
			System.out.println("**********BEFOREEEEEE");
			
			userList = new ArrayList<User>();
			rs = DBUtils.getInstance().query("SELECT * FROM " + AllConstants.DATABASE_TABLE_USER);
			
			while(rs.next()){
				user = new User();
				user.setUserid(rs.getString(AllConstants.USERID));
				user.setName(rs.getString(AllConstants.NAME));
				user.setRole(rs.getString(AllConstants.ROLE));
				user.setPassword(rs.getString(AllConstants.PASSWORD));
				userList.add(user);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userList;
	}
	// TODO: handle exception
	// NEED TO PROVIDE ACCESS ONLY TO ADMIN OR SELF
	public void updateUser(User user){
		try{
			String command = "UPDATE "+ AllConstants.DATABASE_TABLE_USER + " SET "
					+ AllConstants.NAME + "='" + user.getName() + "', "
					+ AllConstants.ROLE + "='" + user.getRole() + "', "
					+ AllConstants.PASSWORD + "='" + user.getPassword() + "' WHERE "
					+ AllConstants.USERID + "=" + user.getUserid() + ""
					;
			System.out.println("command: " + command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
