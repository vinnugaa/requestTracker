package com.tracker.service;

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
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public DataResult<String> doProcessing() {
		DataResult<String> dataResult= null;
		GenericModel srcCountry=null;
		List<GenericModel> allcountries = null;
		GenericModelDAO countryDAO = new GenericModelDAO();
		
		srcCountry = (GenericModel)(new Gson()).fromJson(inputJson, GenericModel.class);
		
		/* TODO ::
		 * Check if there is any necessary to get each country, as the
		 * list of countries is very minimum 
		 */
		
		/*if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_EACH)){
			destcountryName =  countryDAO.getEach(srcCountry);
			if(destcountryName != null){
				dataResult = new DataResult<String>();
				dataResult.isSuccess=true;
				dataResult.data = Utility.getInstance().toJson(destcountryName);
			}
		}else*/
			
		if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ADD)){
			countryDAO.add(srcCountry, AllConstants.DATABASE_TABLE_MARKET);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			//dataResult.data = Utility.getInstance().toJson(destcountryName);
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE)){
			countryDAO.delete(srcCountry,AllConstants.DATABASE_TABLE_MARKET);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_UPDATE)){
			countryDAO.update(srcCountry,AllConstants.DATABASE_TABLE_MARKET);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ALL)){
			//CHECK THE CACHE FIRST
			allcountries = (List<GenericModel>)TrackerCache.getInstance().getObject(AllConstants.CACHE_MARKET_ALL);
			if (! (allcountries != null)) {
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
