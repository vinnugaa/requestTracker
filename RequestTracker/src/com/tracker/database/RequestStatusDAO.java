package com.tracker.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tracker.constants.AllConstants;
import com.tracker.model.RequestStatus;

public class RequestStatusDAO {

	public void add(RequestStatus requestStatus){
		try{
			String command = "INSERT INTO "+ AllConstants.DATABASE_TABLE_REQUEST_STATUS
					+ " VALUES ( '"
					+ requestStatus.getId() + "', '"
					+ requestStatus.getDescription() + "', "
					+ requestStatus.isActive()
					+ " ) ";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public RequestStatus getEach(RequestStatus requestStatus){
		RequestStatus resultRequestStatus = null;
		try{
			String command = "SELECT * FROM " + AllConstants.DATABASE_TABLE_REQUEST_STATUS
					+ " WHERE "+ AllConstants.ID + "='" + requestStatus.getId() +"'";
			System.out.println(command);
			ResultSet rs = DBUtils.getInstance().query(command);
			while(rs.next()){
				resultRequestStatus = new RequestStatus();
				resultRequestStatus.setId(rs.getString(AllConstants.ID));
				resultRequestStatus.setDescription(rs.getString(AllConstants.DESCRIPTION));
				resultRequestStatus.setActive(rs.getBoolean(AllConstants.ACTIVE));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultRequestStatus;
	}
	
	public List<RequestStatus> getAll(){
		List<RequestStatus> allRequestStatus = null;
		try {
			String command = "SELECT * FROM " + AllConstants.DATABASE_TABLE_REQUEST_STATUS;
			System.out.println(command);
			ResultSet rs = DBUtils.getInstance().query(command);
			RequestStatus eachRequestStatus = null;
			allRequestStatus = new ArrayList<RequestStatus>();
			while(rs.next()){
				eachRequestStatus = new RequestStatus();
				eachRequestStatus.setId(rs.getString(AllConstants.ID));
				eachRequestStatus.setDescription(rs.getString(AllConstants.DESCRIPTION));
				eachRequestStatus.setActive(rs.getBoolean(AllConstants.ACTIVE));
				allRequestStatus.add(eachRequestStatus);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return allRequestStatus;
	}
	
	public void update(RequestStatus requestStatus){
		try{
			String command = "UPDATE " + AllConstants.DATABASE_TABLE_REQUEST_STATUS + " SET "
					+ AllConstants.DESCRIPTION + "='" +requestStatus.getDescription() + "'"
					+ AllConstants.ACTIVE + "="+requestStatus.isActive()
					+ " WHERE " + AllConstants.ID +"='" + requestStatus.getId() + "'";
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void delete(RequestStatus requestStatus){
		try {
			String command= "DELETE FROM "+ AllConstants.DATABASE_TABLE_REQUEST_STATUS
					+ " WHERE " + AllConstants.ID + "='"+requestStatus.getId()+"'";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
