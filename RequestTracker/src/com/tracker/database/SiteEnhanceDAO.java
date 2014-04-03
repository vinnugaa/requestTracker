package com.tracker.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sun.security.krb5.internal.EncAPRepPart;

import com.tracker.constants.AllConstants;
import com.tracker.model.DC;
import com.tracker.model.SiteEnhance;
import com.tracker.utils.Utility;

public class SiteEnhanceDAO {

	public void add(SiteEnhance siteEnhance){
	
		try{ 
			Connection conn = DBUtils.getInstance().connect();
			String command = "INSERT INTO "+ AllConstants.DATABASE_TABLE_SITE_ENHANCE
					+ " VALUES ( "+
					"'"	+ siteEnhance.getId() + "', "+
					"'"	+ siteEnhance.getRequestor() + "', "+
					""	+ Utility.getInstance().getSQLDate(siteEnhance.getSubmittedDate(), AllConstants.DATE_FORMAT) + ", "+
					""	+ Utility.getInstance().getSQLDate(siteEnhance.getExpectedDate(), AllConstants.DATE_FORMAT) + ", "+
					""	+ Utility.getInstance().getSQLDate(siteEnhance.getActualDate(), AllConstants.DATE_FORMAT) + ", "+
					""	+ siteEnhance.getHours() + ", "+
					""	+ siteEnhance.getMonth() + ", "+
					""	+ siteEnhance.getProjectId() + ", "+
					""	+ Utility.getInstance().stringToArrayconvertor(siteEnhance.getActualResource(), conn) + ", "+
					"'"	+ siteEnhance.getMeToolResource() + "', "+
					"'"	+ siteEnhance.getActualStatus() + "', "+
					"'"	+ siteEnhance.getMeToolStatus() + "', "+
					"'"	+ siteEnhance.getImpactApplication() + "', "+
					""	+ Utility.getInstance().stringToArrayconvertor(siteEnhance.getChangeType(), conn) + ", "+
					"'"	+ siteEnhance.getBu() + "', "+
					""	+ Utility.getInstance().stringToArrayconvertor(siteEnhance.getCountry(),conn) + ", "+
					"'"	+ siteEnhance.getWorklog() + "', "+
					"'"	+ siteEnhance.isUrgent() + "', "+
					" ) ";
			System.out.println(command);
			DBUtils.getInstance().update(command,conn);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public SiteEnhance getEach(SiteEnhance siteEnhance){
		SiteEnhance result = null;
		try{
			String command = "SELECT * FROM " + AllConstants.DATABASE_TABLE_SITE_ENHANCE
					+ " WHERE "+ AllConstants.ID + "='" + siteEnhance.getId() +"'";
			System.out.println(command);
			ResultSet rs = DBUtils.getInstance().query(command);
			while(rs.next()){
				result = new SiteEnhance();
				result.setId(rs.getString(0));
				result.setRequestor(rs.getString(1));
				result.setSubmittedDate(rs.getString(2));
				result.setExpectedDate(rs.getString(3));
				result.setActualDate(rs.getString(4));
				result.setHours(Double.parseDouble(rs.getString(5)));
				result.setMonth(Integer.parseInt(rs.getString(6)));
				result.setProjectId(Integer.parseInt(rs.getString(7)));
				result.setActualResource(rs.getString(8));
				result.setMeToolResource(Integer.parseInt(rs.getString(9)));
				result.setActualStatus(Integer.parseInt(rs.getString(10)));
				result.setMeToolStatus(Integer.parseInt(rs.getString(11)));
				result.setImpactApplication(Integer.parseInt(rs.getString(12)));
				result.setChangeType(rs.getString(13));
				result.setBu(Integer.parseInt(rs.getString(14)));
				result.setCountry(rs.getString(15));
				result.setWorklog(Integer.parseInt(rs.getString(16)));
				result.setUrgent(Boolean.parseBoolean(rs.getString(17)));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public List<SiteEnhance> getAll(){
		List<SiteEnhance> enhancements = null;
		try {
			String command = "SELECT * FROM " + AllConstants.DATABASE_TABLE_SITE_ENHANCE;
			System.out.println(command);
			ResultSet rs = DBUtils.getInstance().query(command);
			SiteEnhance eachEnhancement = null;
			enhancements = new ArrayList<SiteEnhance>();
			while(rs.next()){
				eachEnhancement = new SiteEnhance();
				eachEnhancement.setId(rs.getString(0));
				eachEnhancement.setRequestor(rs.getString(1));
				eachEnhancement.setSubmittedDate(rs.getString(2));
				eachEnhancement.setExpectedDate(rs.getString(3));
				eachEnhancement.setActualDate(rs.getString(4));
				eachEnhancement.setHours(Double.parseDouble(rs.getString(5)));
				eachEnhancement.setMonth(Integer.parseInt(rs.getString(6)));
				eachEnhancement.setProjectId(Integer.parseInt(rs.getString(7)));
				eachEnhancement.setActualResource(rs.getString(8));
				eachEnhancement.setMeToolResource(Integer.parseInt(rs.getString(9)));
				eachEnhancement.setActualStatus(Integer.parseInt(rs.getString(10)));
				eachEnhancement.setMeToolStatus(Integer.parseInt(rs.getString(11)));
				eachEnhancement.setImpactApplication(Integer.parseInt(rs.getString(12)));
				eachEnhancement.setChangeType(rs.getString(13));
				eachEnhancement.setBu(Integer.parseInt(rs.getString(14)));
				eachEnhancement.setCountry(rs.getString(15));
				eachEnhancement.setWorklog(Integer.parseInt(rs.getString(16)));
				eachEnhancement.setUrgent(Boolean.parseBoolean(rs.getString(17)));
				enhancements.add(eachEnhancement);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return enhancements;
	}
	
	public void update(SiteEnhance enhancement){
		try{
			String command = "UPDATE " + AllConstants.DATABASE_TABLE_SITE_ENHANCE + " SET "
					+ AllConstants.REQUESTOR + "='" + enhancement.getRequestor() + "'"
					+ AllConstants.SUBMITTED_DATE + "='" + enhancement.getSubmittedDate() + "'"
					+ AllConstants.EXPECTED_DATE + "='" + enhancement.getExpectedDate() + "'"
					+ AllConstants.ACTUAL_DATE + "='" + enhancement.getActualDate() + "'"
					+ AllConstants.HOURS + "='" + enhancement.getHours() + "'"
					+ AllConstants.MONTH + "='" + enhancement.getMonth() + "'"
					+ AllConstants.ACTUAL_RESOURCE + "='" + enhancement.getActualResource() + "'"
					+ AllConstants.METOOL_RESOURCE + "='" + enhancement.getMeToolResource() + "'"
					+ AllConstants.ACTUAL_STATUS + "='" + enhancement.getActualStatus() + "'"
					+ AllConstants.METOOL_STATUS + "='" + enhancement.getMeToolStatus() + "'"
					+ AllConstants.IMPACTED_APPLICATION + "='" + enhancement.getImpactApplication() + "'"
					+ AllConstants.CHANGE_TYPE + "='" + enhancement.getChangeType() + "'"
					+ AllConstants.BU + "='" + enhancement.getBu() + "'"
					+ AllConstants.COUNTRY + "='" + enhancement.getCountry() + "'"
					+ AllConstants.WORKLOG + "='" + enhancement.getWorklog() + "'"
					+ AllConstants.URGENT + "='" + enhancement.isUrgent() + "'"
					
					+ " WHERE " + AllConstants.ID +"='" + enhancement.getId() + "'";
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void delete(SiteEnhance enhancement){
		try {
			String command= "DELETE FROM "+ AllConstants.DATABASE_TABLE_SITE_ENHANCE
					+ " WHERE " + AllConstants.ID + "='"+enhancement.getId()+"'";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
