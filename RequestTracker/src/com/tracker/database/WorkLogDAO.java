package com.tracker.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tracker.constants.AllConstants;
import com.tracker.model.WorkLog;

public class WorkLogDAO {
	
	DatabaseTablesDAO dbtablesDAO = new DatabaseTablesDAO();

	public WorkLog getEach(WorkLog workLog, String tableName){
		WorkLog resultWorkLog = null;
		try {
			if(!dbtablesDAO.getAllTables().contains(tableName)) { System.out.println("TABLE NOT PRESENT " + tableName); return null;}
			String command = "SELECT * FROM " + tableName 
					+ " WHERE " + AllConstants.ID + "='" + workLog.getId() + "'";
			ResultSet rs = DBUtils.getInstance().query(command);
			
			while(rs.next()){
				resultWorkLog = new WorkLog();
				resultWorkLog.setId(rs.getString(AllConstants.ID));
				resultWorkLog.setRequestId(rs.getString(AllConstants.REQUEST_ID));
				resultWorkLog.setDate(rs.getString(AllConstants.DATE));
				resultWorkLog.setLog(rs.getString(AllConstants.LOG));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultWorkLog;
	}
	
	public void add(WorkLog workLog, String tableName){
		try {
			String command = "INSERT INTO " + tableName + " VALUES ( '"
					+ workLog.getId() + "', '"
					+ workLog.getRequestId() + "', '"
					+ workLog.getDate() + "', '"
					+ workLog.getLog() + "'"
					+ " ) ";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void update(WorkLog workLog, String tableName){
		try {
			String command = "UPDATE " + tableName + " SET "
					+ AllConstants.REQUEST_ID + "='" + workLog.getRequestId() + "', "
					+ AllConstants.DATE + "='" + workLog.getDate() + "', "
					+ AllConstants.LOG + "='" + workLog.getLog() + "', "
					+ " WHERE " + AllConstants.ID + "='" +workLog.getId() + "'";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public List<WorkLog> getAll(String tableName){
		List<WorkLog> allworkLog = null;
		WorkLog resultWorkLog = null;
		try {
			if(!dbtablesDAO.getAllTables().contains(tableName)) { System.out.println("TABLE NOT PRESENT " + tableName); return null;}
			String command = "SELECT * FROM " + tableName;
			ResultSet rs = DBUtils.getInstance().query(command);
			allworkLog = new ArrayList<WorkLog>();
			
			while(rs.next()){
				resultWorkLog = new WorkLog();
				resultWorkLog.setId(rs.getString(AllConstants.ID));
				resultWorkLog.setRequestId(rs.getString(AllConstants.REQUEST_ID));
				resultWorkLog.setDate(rs.getString(AllConstants.DATE));
				resultWorkLog.setLog(rs.getString(AllConstants.LOG));
				allworkLog.add(resultWorkLog);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return allworkLog;
	}
	
	public void delete(WorkLog workLog, String tableName){
		try {
			String command= "DELETE FROM "+ tableName
					+ " WHERE " + AllConstants.ID + "='"+workLog.getId()+"'";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
