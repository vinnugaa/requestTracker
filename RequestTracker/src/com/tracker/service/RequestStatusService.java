package com.tracker.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tracker.cache.TrackerCache;
import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.database.RequestStatusDAO;
import com.tracker.model.RequestStatus;
import com.tracker.utils.Utility;

public class RequestStatusService extends BusinessService{

	public RequestStatusService(String method, String inputJson) {
		super(method, inputJson);
	}

	@Override
	public DataResult<String> doProcessing() {
		DataResult<String> dataResult= new DataResult<String>();
		RequestStatus srcRequestStatus=null, destRequestStatus=null;
		List<RequestStatus> allRequestStatus = null;
		RequestStatusDAO requestStatusDAO = new RequestStatusDAO();
		
		srcRequestStatus = (RequestStatus)(new Gson()).fromJson(inputJson, RequestStatus.class);
		
		if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_EACH)){
			destRequestStatus =  requestStatusDAO.getEach(srcRequestStatus);
			if(destRequestStatus != null){
				dataResult.isSuccess=true;
				dataResult.data = Utility.getInstance().toJson(destRequestStatus);
			}
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ADD)){
			requestStatusDAO.add(srcRequestStatus);
			dataResult.isSuccess=true;
			//dataResult.data = Utility.getInstance().toJson(destRequestStatus);
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE)){
			requestStatusDAO.delete(srcRequestStatus);
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_UPDATE)){
			requestStatusDAO.update(srcRequestStatus);
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ALL)){
			//CHECK THE CACHE FIRST
			allRequestStatus = (ArrayList<RequestStatus>)TrackerCache.getInstance().getObject(AllConstants.CACHE_RequestStatus_ALL);
			if (allRequestStatus != null) {
				/*dataResult = new DataResult<String>();
				dataResult.data = Utility.getInstance().toJson(allRequestStatus);
				dataResult.isSuccess=true;*/
			}else {
				allRequestStatus = requestStatusDAO.getAll();
				TrackerCache.getInstance().addObject(AllConstants.CACHE_RequestStatus_ALL, allRequestStatus);
			}
			dataResult.data = Utility.getInstance().toJson(allRequestStatus);
			dataResult.isSuccess=true;
			
		}
		
		return dataResult;
	}

}

