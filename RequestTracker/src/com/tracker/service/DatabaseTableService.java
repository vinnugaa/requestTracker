package com.tracker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.database.DBUtils;
import com.tracker.database.DatabaseTablesDAO;
import com.tracker.utils.Utility;

public class DatabaseTableService extends BusinessService {
	
	private Map<String, String> tableMap = null;
	private List<String> existingTables = null;

	public DatabaseTableService(String method, String inputJson) {
		super(method, inputJson);
		tableMap = new HashMap<String, String>();
		tableMap.put(AllConstants.DATABASE_TABLE_USER, AllConstants.DATABASE_TABLE_USER_DESCRIPTION);
		tableMap.put(AllConstants.DATABASE_TABLE_PROJECT_ID, AllConstants.DATABASE_TABLE_PROJECT_ID_DESCRIPTION);
		tableMap.put(AllConstants.DATABASE_TABLE_REQUEST_TYPE, AllConstants.DATABASE_TABLE_REQUEST_TYPE_DESCRIPTION);
		tableMap.put(AllConstants.DATABASE_TABLE_MARKET, AllConstants.DATABASE_TABLE_MARKET_DESCRIPTION);
		tableMap.put(AllConstants.DATABASE_TABLE_BU , AllConstants.DATABASE_TABLE_BU_DESCRIPTION);
		tableMap.put(AllConstants.DATABASE_TABLE_IMPACTED_APP , AllConstants.DATABASE_TABLE_IMPACTED_APP_DESCRIPTION);
		tableMap.put(AllConstants.DATABASE_TABLE_REQUEST_STATUS , AllConstants.DATABASE_TABLE_REQUEST_STATUS_DESCRIPTION);
		tableMap.put(AllConstants.DATABASE_TABLE_METOOL_STATUS , AllConstants.DATABASE_TABLE_METOOL_STATUS_DESCRIPTION);
		tableMap.put(AllConstants.DATABASE_TABLE_WORL_LOG , AllConstants.DATABASE_TABLE_WORL_LOG_DESCRIPTION);
		try {
			DatabaseTablesDAO dbTablesDAO = new DatabaseTablesDAO();
			existingTables = dbTablesDAO.getAllTables();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public DataResult<String> doProcessing() {
		DataResult<String> dataResult = new DataResult<String>();
		String command = "";
		
		if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_CREATE)){
			
			try{
				if(existingTables.contains(inputJson)) { System.out.println("TABLE " + inputJson + " Already existing");return dataResult; }
				command = "CREATE TABLE "+ inputJson + tableMap.get(inputJson);
				DBUtils.getInstance().update(command);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_CREATE_ALL)){
			
			try{
				for(Entry<String, String> entry : tableMap.entrySet()){
					command = "CREATE TABLE "+ entry.getKey() + entry.getValue();
					DBUtils.getInstance().update(command);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ALL)){
			
			dataResult.data = Utility.getInstance().toJson(existingTables);
			dataResult.isSuccess = true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_PURGE_ALL)){
			
			try {
				for(String eachTable : existingTables){
					command = "DELETE * FROM " + eachTable;
					DBUtils.getInstance().update(command);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			dataResult.isSuccess = true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_PURGE_EACH)){
			
			try {
				if(!existingTables.contains(inputJson.trim())) { System.out.println("TABLE " + inputJson.trim() + " Already removed");return dataResult; }
				command = "DELETE * FROM " + inputJson.trim();
				DBUtils.getInstance().update(command);
			}catch (Exception e) {
				e.printStackTrace();
			}
			dataResult.isSuccess = true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE)){
			
			try {
				if(!existingTables.contains(inputJson.trim())) { System.out.println("TABLE " + inputJson.trim() + " Already removed");return dataResult; }
				command = "DROP TABLE " + inputJson.trim() + " IF EXISTS";
				DBUtils.getInstance().update(command);
			}catch (Exception e) {
				e.printStackTrace();
			}
			dataResult.isSuccess = true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE_ALL)){
			
			try {
				for(String eachTable : existingTables){
					command = "DROP TABLE " + eachTable + " IF EXISTS";
					DBUtils.getInstance().update(command);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			dataResult.isSuccess = true;
			
		}
		
		return dataResult;
	}

}
