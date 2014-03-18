package com.tracker.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.tracker.constants.AllConstants;

public class InitDAO {

	private Map<String, String> tableMap = null;
	private List<String> existingTables = null;
	
	public InitDAO() {
		// TODO Auto-generated constructor stub
		tableMap = new HashMap<String, String>();
		tableMap.put(AllConstants.DATABASE_TABLE_USER, " ( userid VARCHAR IDENTITY, name VARCHAR(50), role VARCHAR(20), password VARCHAR(20) )");
		tableMap.put(AllConstants.DATABASE_TABLE_PROJECT_ID, " ( id VARCHAR(10), description VARCHAR(100), active BOOLEAN, PRIMARY KEY(id) )");
		tableMap.put(AllConstants.DATABASE_TABLE_REQUEST_TYPE, " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )");
		tableMap.put(AllConstants.DATABASE_TABLE_MARKET, " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )");
		tableMap.put(AllConstants.DATABASE_TABLE_BU , " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )");
		tableMap.put(AllConstants.DATABASE_TABLE_IMPACTED_APP , " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )");
		tableMap.put(AllConstants.DATABASE_TABLE_REQUEST_STATUS , " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )");
		tableMap.put(AllConstants.DATABASE_TABLE_METOOL_STATUS , " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )");
		tableMap.put(AllConstants.DATABASE_TABLE_WORL_LOG , " ( id VARCHAR(10) IDENTITY, request_id VARCHAR(10), log_date DATE, log LONGVARCHAR )");
		
		try {
			existingTables = DBUtils.getInstance().getAllTables();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void createTable(String tableName){
		String command="";
		try{
			
			if(existingTables.contains(tableName)) { System.out.println("TABLE " + tableName + " Already existing");return; }
			
			if(tableMap.get(tableName)!=null){
				command = "CREATE TABLE "+ tableName + tableMap.get(tableName);
				DBUtils.getInstance().update(command);	
			}else if(tableName.equalsIgnoreCase("all")){
				for(Entry<String, String> entry : tableMap.entrySet()){
					command = "CREATE TABLE "+ entry.getKey() + entry.getValue();
					DBUtils.getInstance().update(command);
				}
			}else {
				System.out.println("WRONG TABLE NAME!! " + tableName);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void purgeTable(String tableName){
		String command="";
		try{
			if(tableMap.get(tableName)!=null){
				command = "DELETE FROM " + tableName;
				DBUtils.getInstance().update(command);
			}else if(tableName.equalsIgnoreCase("all")){
				for(Entry<String, String> entry : tableMap.entrySet()){
					command = "DELETE FROM " + entry.getKey();
					DBUtils.getInstance().update(command);
				}
			}else {
				System.out.println("WRONG TABLE NAME!! " + tableName);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/* 
	 * USE THIS UNLESS YOU MODIFY THE STRUCTURE OF THE TABLE / ATTRIBUTES
	 */
	public void removeTable(String tableName){
		String command="";
		try {
			if(!existingTables.contains(tableName)) { System.out.println("TABLE " + tableName + " Already removed");return; }
			
			if(tableMap.get(tableName)!=null){
				command = "DROP TABLE " + tableName + " IF EXISTS";
				DBUtils.getInstance().update(command);
			}else if(tableName.equalsIgnoreCase("all")){
				for(Entry<String, String> entry : tableMap.entrySet()){
					command = "DROP TABLE " + entry.getKey() + " IF EXISTS";
					DBUtils.getInstance().update(command);
				}
			}else {
				System.out.println("WRONG TABLE NAME!! " + tableName);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/*
	public void createUserTable(){
		try {
			String command = "CREATE TABLE " + AllConstants.DATABASE_USER_TABLE + " ( userid VARCHAR IDENTITY, name VARCHAR(50), role VARCHAR(20), password VARCHAR(20) )";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void createProjecctIDTable(){
		try {
			String command = "CREATE TABLE " + AllConstants.DATABASE_PROJECT_ID_TABLE + " ( id VARCHAR(10), description VARCHAR(100), active BOOLEAN, PRIMARY KEY(id) )";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void createRequestTypeTable(){
		try {
			String command = "CREATE TABLE " + AllConstants.DATABASE_REQUEST_TYPE_TABLE+ " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void createMarketTable(){
		try {
			String command = "CREATE TABLE " + AllConstants.DATABASE_MARKET_TABLE+ " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void createBUTable(){
		try {
			String command = "CREATE TABLE " + AllConstants.DATABASE_BU_TABLE + " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void createImpactedAppTable(){
		try {
			String command = "CREATE TABLE " + AllConstants.DATABASE_IMPACTED_APP_TABLE + " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void createRequestStatusTable(){
		try {
			String command = "CREATE TABLE " + AllConstants.DATABASE_REQUEST_STATUS_TABLE + " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void createMEToolStatusTable(){
		try {
			String command = "CREATE TABLE " + AllConstants.DATABASE_METOOL_STATUS_TABLE + " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )";
			System.out.println(command);
			DBUtils.getInstance().update(command);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	*/
}
