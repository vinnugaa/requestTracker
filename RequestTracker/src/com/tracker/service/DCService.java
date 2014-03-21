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

	@Override
	public DataResult<String> doProcessing() {
		DataResult<String> dataResult= new DataResult<String>();
		DC srcDC=null, destDC=null;
		List<DC> allDC = null;
		DcDAO dcDAO = new DcDAO();
		
		srcDC = (DC)(new Gson()).fromJson(inputJson, DC.class);
		
		if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_EACH)){
			destDC =  dcDAO.getEach(srcDC);
			if(destDC != null){
				dataResult.isSuccess=true;
				dataResult.data = Utility.getInstance().toJson(destDC);
			}
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ADD)){
			dcDAO.add(srcDC);
			dataResult.isSuccess=true;
			//dataResult.data = Utility.getInstance().toJson(destUser);
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE)){
			dcDAO.delete(srcDC);
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_UPDATE)){
			dcDAO.update(srcDC);
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ALL)){
			//CHECK THE CACHE FIRST
			allDC = (ArrayList<DC>)TrackerCache.getInstance().getObject(AllConstants.CACHE_DC_ALL);
			if (allDC != null) {
				/*dataResult = new DataResult<String>();
				dataResult.data = Utility.getInstance().toJson(allUsers);
				dataResult.isSuccess=true;*/
			}else {
				allDC = dcDAO.getAll();
				TrackerCache.getInstance().addObject(AllConstants.CACHE_DC_ALL, allDC);
			}
			dataResult.data = Utility.getInstance().toJson(allDC);
			dataResult.isSuccess=true;
			
		}
		
		return dataResult;
	}

}
