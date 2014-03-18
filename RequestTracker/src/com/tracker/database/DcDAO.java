package com.tracker.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tracker.constants.AllConstants;
import com.tracker.model.DC;

public class DcDAO {

	
	public void add(DC dc){
		try{
			String command = "INSERT INTO "+ AllConstants.DATABASE_TABLE_PROJECT_ID
					+ " VALUES ( '"
					+ dc.getId() + "', '"
					+ dc.getDescription() + "', "
					+ dc.isActive()
					+ " ) ";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public DC getEach(DC dc){
		DC resultDC = null;
		try{
			String command = "SELECT * FROM " + AllConstants.DATABASE_TABLE_PROJECT_ID
					+ " WHERE "+ AllConstants.ID + "='" + dc.getId() +"'";
			System.out.println(command);
			ResultSet rs = DBUtils.getInstance().query(command);
			while(rs.next()){
				resultDC = new DC();
				resultDC.setId(rs.getString(AllConstants.ID));
				resultDC.setDescription(rs.getString(AllConstants.DESCRIPTION));
				resultDC.setActive(rs.getBoolean(AllConstants.ACTIVE));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultDC;
	}
	
	public List<DC> getAll(){
		List<DC> allDC = null;
		try {
			String command = "SELECT * FROM " + AllConstants.DATABASE_TABLE_PROJECT_ID;
			System.out.println(command);
			ResultSet rs = DBUtils.getInstance().query(command);
			DC eachDC = null;
			allDC = new ArrayList<DC>();
			while(rs.next()){
				eachDC = new DC();
				eachDC.setId(rs.getString(AllConstants.ID));
				eachDC.setDescription(rs.getString(AllConstants.DESCRIPTION));
				eachDC.setActive(rs.getBoolean(AllConstants.ACTIVE));
				allDC.add(eachDC);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return allDC;
	}
	
	public void update(DC dc){
		try{
			String command = "UPDATE " + AllConstants.DATABASE_TABLE_PROJECT_ID + " SET "
					+ AllConstants.DESCRIPTION + "='" + dc.getDescription() + "'"
					+ AllConstants.ACTIVE + "="+dc.isActive()
					+ " WHERE " + AllConstants.ID +"='" + dc.getId() + "'";
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void delete(DC dc){
		try {
			String command= "DELETE FROM "+ AllConstants.DATABASE_TABLE_PROJECT_ID
					+ " WHERE " + AllConstants.ID + "='"+dc.getId()+"'";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
