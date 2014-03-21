package com.tracker.service;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.tracker.cache.TrackerCache;
import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.database.GenericModelDAO;
import com.tracker.model.GenericModel;
import com.tracker.utils.Utility;


public class MarketService extends BusinessService {
	
	public MarketService(String method, String inputJson) {
		super(method, inputJson);
		// TODO Auto-generated constructor stub
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public DataResult<String> doProcessing() {
		// TODO Auto-generated method stub
		DataResult<String> dataResult= null;
		GenericModel srccountryName=null, destcountryName=null;
		List<GenericModel> allcountries = null;
		GenericModelDAO countryDAO = new GenericModelDAO();
		
		srccountryName = (GenericModel)(new Gson()).fromJson(inputJson, GenericModel.class);
		
		/*if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_EACH)){
			destcountryName =  countryDAO.getEach(srccountryName);
			if(destcountryName != null){
				dataResult = new DataResult<String>();
				dataResult.isSuccess=true;
				dataResult.data = Utility.getInstance().toJson(destcountryName);
			}
		}else*/
			
			if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ADD)){
			countryDAO.add(srccountryName, AllConstants.DATABASE_TABLE_MARKET);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			//dataResult.data = Utility.getInstance().toJson(destcountryName);
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE)){
			countryDAO.delete(srccountryName,AllConstants.DATABASE_TABLE_MARKET);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_UPDATE)){
			countryDAO.update(srccountryName,AllConstants.DATABASE_TABLE_MARKET);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ALL)){
			//CHECK THE CACHE FIRST
			allcountries = (List<GenericModel>)TrackerCache.getInstance().getObject(AllConstants.CACHE_MARKET_ALL);
			if (allcountries != null) {
				/*dataResult = new DataResult<String>();
				dataResult.data = Utility.getInstance().toJson(allcountries);
				dataResult.isSuccess=true;*/
			}else {
				allcountries = countryDAO.getAll(AllConstants.DATABASE_TABLE_MARKET);
				TrackerCache.getInstance().addObject(AllConstants.CACHE_MARKET_ALL,allcountries);
			}
			dataResult = new DataResult<String>();
			dataResult.data = Utility.getInstance().toJson(allcountries);
			dataResult.isSuccess=true;
			
		}
		
		return dataResult;
	}

}
