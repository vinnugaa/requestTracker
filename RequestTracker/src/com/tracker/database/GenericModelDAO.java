package com.tracker.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tracker.constants.AllConstants;
import com.tracker.model.GenericModel;

public class GenericModelDAO {

	DatabaseTablesDAO dbtablesDAO = new DatabaseTablesDAO();
	
	public GenericModel getEach(GenericModel model, String tableName){
		GenericModel resultModel = null;
		try {
			if(!dbtablesDAO.getAllTables().contains(tableName)) { System.out.println("TABLE NOT PRESENT " + tableName); return null;}
			String command = "SELECT * FROM " + tableName 
					+ " WHERE " + AllConstants.ID + "='" + model.getId() + "'";
			ResultSet rs = DBUtils.getInstance().query(command);
			
			while(rs.next()){
				resultModel = new GenericModel();
				resultModel.setId(rs.getString(AllConstants.ID));
				resultModel.setName(rs.getString(AllConstants.NAME));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultModel;
	}
	
	public void add(GenericModel model, String tableName){
		try {
			String command = "INSERT INTO " + tableName + " VALUES ( '"
					+ model.getId() + "', "
					+ model.getName() + "' "
					+ " ) ";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void update(GenericModel model, String tableName){
		try {
			String command = "UPDATE " + tableName + " SET "
					+ AllConstants.NAME + "='" + model.getName() + "' "
					+ " WHERE " + AllConstants.ID + "='" +model.getId() + "'";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<GenericModel> getAll(String tableName){
		List<GenericModel> allModel = null;
		GenericModel resultModel = null;
		try {
			if(!dbtablesDAO.getAllTables().contains(tableName)) { System.out.println("TABLE NOT PRESENT " + tableName); return null;}
			String command = "SELECT * FROM " + tableName;
			ResultSet rs = DBUtils.getInstance().query(command);
			allModel = new ArrayList<GenericModel>();
			
			while(rs.next()){
				resultModel = new GenericModel();
				resultModel.setId(rs.getString(AllConstants.ID));
				resultModel.setName(rs.getString(AllConstants.NAME));
				allModel.add(resultModel);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return allModel;
	}
	
	public void delete(GenericModel model, String tableName){
		try {
			String command= "DELETE FROM "+ tableName
					+ " WHERE " + AllConstants.ID + "='"+model.getId()+"'";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
