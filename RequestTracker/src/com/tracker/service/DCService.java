package com.tracker.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tracker.cache.TrackerCache;
import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.database.DcDAO;
import com.tracker.model.DC;
import com.tracker.utils.Utility;

public class DCService extends BusinessService{

	public DCService(String method, String inputJson) {
		super(method, inputJson);
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataResult<String> doProcessing() {
		DataResult<String> dataResult=null;
		DC dc=null;
		List<DC> allDC = null;
		DcDAO dcDAO = new DcDAO();
		
		dc = (DC)(new Gson()).fromJson(inputJson, DC.class);
		if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_EACH)){
			dc = (DC)trackerCache.getObject(AllConstants.CACHE_DC+dc.getId());
			if (!(dc !=null)){
				dc =  dcDAO.getEach(dc);
			}
			dataResult= new DataResult<String>();
			dataResult.isSuccess=true;
			dataResult.data = Utility.getInstance().toJson(dc);
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ADD)){
			dcDAO.add(dc);
			trackerCache.addObject(AllConstants.CACHE_DC+dc.getId(), dc);
			dataResult= new DataResult<String>();
			dataResult.isSuccess=true;
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE)){
			dcDAO.delete(dc);
			trackerCache.removeObject(dc.getId());
			dataResult= new DataResult<String>();
			dataResult.isSuccess=true;
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_UPDATE)){
			dcDAO.update(dc);
			trackerCache.addObject(AllConstants.CACHE_DC+dc.getId(), dc);
			dataResult= new DataResult<String>();
			dataResult.isSuccess=true;
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ALL)){
			//CHECK THE CACHE FIRST
			allDC = (ArrayList<DC>)TrackerCache.getInstance().getObject(AllConstants.CACHE_DC+AllConstants.CACHE_ALL);
			if (!(allDC != null)) {
				allDC = dcDAO.getAll();
				TrackerCache.getInstance().addObject(AllConstants.CACHE_DC+AllConstants.CACHE_ALL, allDC);
			}
			dataResult = new DataResult<String>();
			dataResult.data = Utility.getInstance().toJson(allDC);
			dataResult.isSuccess=true;
			
		}
		
		return dataResult;
	}

}
