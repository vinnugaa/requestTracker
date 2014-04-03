package com.tracker.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tracker.cache.TrackerCache;
import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.database.SiteEnhanceDAO;
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
		SiteEnhance srcEnhance = null, destEnhance = null;
		List<SiteEnhance> allEnhance = null;
		SiteEnhanceDAO enhanceDAO = new SiteEnhanceDAO();
		
		srcEnhance = (SiteEnhance)(new Gson()).fromJson(inputJson, SiteEnhance.class);
		if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_EACH)){
			destEnhance = enhanceDAO.getEach(srcEnhance);
			if(destEnhance != null){
				dataResult.isSuccess=true;
				dataResult.data = Utility.getInstance().toJson(destEnhance);
			}
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ADD)){
			enhanceDAO.add(srcEnhance);
			dataResult.isSuccess=true;
			//dataResult.data = Utility.getInstance().toJson(destUser);
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE)){
			enhanceDAO.delete(srcEnhance);
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_UPDATE)){
			enhanceDAO.update(srcEnhance);
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ALL)){
			//CHECK THE CACHE FIRST
			allEnhance = (ArrayList<SiteEnhance>)TrackerCache.getInstance().getObject(AllConstants.CACHE_SITE_ENHANCE);
			if (allEnhance != null) {	}else {
				allEnhance = enhanceDAO.getAll();
				TrackerCache.getInstance().addObject(AllConstants.CACHE_SITE_ENHANCE, allEnhance);
			}
			dataResult.data = Utility.getInstance().toJson(allEnhance);
			dataResult.isSuccess=true;
			
		}
		
		return dataResult;
	}

}
