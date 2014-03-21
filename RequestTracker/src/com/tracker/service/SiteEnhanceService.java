package com.tracker.service;

import java.util.ArrayList;

import com.tracker.cache.TrackerCache;
import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.model.DC;
import com.tracker.model.SiteEnhance;
import com.tracker.utils.Utility;

public class SiteEnhanceService extends BusinessService{

	public SiteEnhanceService(String method, String inputJson) {
		super(method, inputJson);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DataResult<String> doProcessing() {
		// TODO Auto-generated method stub
		DataResult<String> dataResult = new DataResult<String>();
		SiteEnhance siteEnhance;
		
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
