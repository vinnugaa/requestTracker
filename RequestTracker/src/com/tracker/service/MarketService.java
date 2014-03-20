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


public class MarketService extends BusinessService {
	
	public MarketService(String method, String inputJson) {
		super(method, inputJson);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public DataResult<String> doProcessing() {
		// TODO Auto-generated method stub
		DataResult<String> dataResult= null;
		DC srccountryName=null, destcountryName=null;
		List<countryName> allcountries = null;
		MarketDAO marketDAO = new MarketDAO();
		
		srccountryName = (marketDAO)(new Gson()).fromJson(inputJson, Market.class);
		
		if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_EACH)){
			destcountryName =  marketDAO.getEach(srccountryName);
			if(destcountryName != null){
				dataResult = new DataResult<String>();
				dataResult.isSuccess=true;
				dataResult.data = Utility.getInstance().toJson(destcountryName);
			}
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ADD)){
			marketDAO.add(srccountryName);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			//dataResult.data = Utility.getInstance().toJson(destcountryName);
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE)){
			marketDAO.delete(srccountryName);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_UPDATE)){
			marketDAO.update(srccountryName);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ALL)){
			//CHECK THE CACHE FIRST
			allcountries = (ArrayList<marketDAO>)TrackerCache.getInstance().getObject(AllConstants.CACHE_MARKET_ALL);
			if (allcountries != null) {
				/*dataResult = new DataResult<String>();
				dataResult.data = Utility.getInstance().toJson(allcountries);
				dataResult.isSuccess=true;*/
			}else {
				allcountries = marketDAO.getAll();
				TrackerCache.getInstance().addObject(AllConstants.CACHE_DC_ALL, allcountries);
			}
			dataResult = new DataResult<String>();
			dataResult.data = Utility.getInstance().toJson(allcountries);
			dataResult.isSuccess=true;
			
		}
		
		return dataResult;
	}

}
