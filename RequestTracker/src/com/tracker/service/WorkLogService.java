package com.tracker.service;

import java.util.List;

import com.google.gson.Gson;
import com.tracker.cache.TrackerCache;
import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.database.WorkLogDAO;
import com.tracker.model.WorkLog;
import com.tracker.utils.Utility;

public class WorkLogService extends BusinessService {

	public WorkLogService(String method, String inputJson) {
		super(method, inputJson);
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataResult<String> doProcessing() {
		// TODO Auto-generated method stub
		DataResult<String> dataResult= null;
		WorkLog srcWorkLog = null;
		List<WorkLog> workLogs = null;
		WorkLogDAO workLogDAO = new WorkLogDAO();
		
		srcWorkLog = (WorkLog)(new Gson()).fromJson(inputJson, WorkLog.class);
		
		/* TODO ::
		 * Check if there is any necessary to get each country, as the
		 * list of countries is very minimum 
		 */
		
		/*if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_EACH)){
			destcountryName =  workLogDAO.getEach(srcWorkLog);
			if(destcountryName != null){
				dataResult = new DataResult<String>();
				dataResult.isSuccess=true;
				dataResult.data = Utility.getInstance().toJson(destcountryName);
			}
		}else*/
			
		if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ADD)){
			workLogDAO.add(srcWorkLog, AllConstants.DATABASE_TABLE_WORL_LOG);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			//dataResult.data = Utility.getInstance().toJson(destcountryName);
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE)){
			workLogDAO.delete(srcWorkLog,AllConstants.DATABASE_TABLE_WORL_LOG);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_UPDATE)){
			workLogDAO.update(srcWorkLog,AllConstants.DATABASE_TABLE_WORL_LOG);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ALL)){
			//CHECK THE CACHE FIRST
			workLogs = (List<WorkLog>)TrackerCache.getInstance().getObject(AllConstants.CACHE_MARKET_ALL);
			if (! (workLogs != null)) {
				workLogs = workLogDAO.getAll(AllConstants.DATABASE_TABLE_WORL_LOG);
				TrackerCache.getInstance().addObject(AllConstants.CACHE_MARKET_ALL,workLogs);
			}
			dataResult = new DataResult<String>();
			dataResult.data = Utility.getInstance().toJson(workLogs);
			dataResult.isSuccess=true;
			
		}
		
		return dataResult;
	}
	

}
