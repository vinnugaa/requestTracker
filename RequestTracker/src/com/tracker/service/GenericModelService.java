package com.tracker.service;

import java.util.List;

import com.google.gson.Gson;
import com.tracker.cache.TrackerCache;
import com.tracker.constants.AllConstants;
import com.tracker.data.DataResult;
import com.tracker.database.GenericModelDAO;
import com.tracker.model.GenericModel;
import com.tracker.utils.Utility;


public class GenericModelService extends BusinessService {
	
	String dbTableName = "";
	
	public GenericModelService(String method, String inputJson) {
		super(method, inputJson);
	}
	
	public String getDBTable(String method){
		String result="";
		/* TODO
		 * 		MAP all the database tables with the services
		 */
		
		if(method.equalsIgnoreCase(AllConstants.SERVICE_MAIN_MARKET))
			dbTableName = AllConstants.DATABASE_TABLE_MARKET;
		else if(method.equalsIgnoreCase(AllConstants.SERVICE_MAIN_MARKET))
			dbTableName ="";
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataResult<String> doProcessing() {
		
		
		
		DataResult<String> dataResult= null;
		GenericModel srcGenericModel=null;
		List<GenericModel> allGenericModels = null;
		GenericModelDAO genericModelDAO = new GenericModelDAO();
		
		srcGenericModel = (GenericModel)(new Gson()).fromJson(inputJson, GenericModel.class);
		String dabaseTableName = getDBTable(srcGenericModel.getType());
		
		/* TODO ::
		 * Check if there is any necessary to get each country, as the
		 * list of countries is very minimum 
		 */
		
		/*if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_EACH)){
			destcountryName =  genericModelDAO.getEach(srcGenericModel);
			if(destcountryName != null){
				dataResult = new DataResult<String>();
				dataResult.isSuccess=true;
				dataResult.data = Utility.getInstance().toJson(destcountryName);
			}
		}else*/
			
		if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ADD)){
			genericModelDAO.add(srcGenericModel, dabaseTableName);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			//dataResult.data = Utility.getInstance().toJson(destcountryName);
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE)){
			genericModelDAO.delete(srcGenericModel,dabaseTableName);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_UPDATE)){
			genericModelDAO.update(srcGenericModel,dabaseTableName);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ALL)){
			//CHECK THE CACHE FIRST
			/* TODO
			 * 		I don't know if I can use (!(variable != null)), but for sure should not use (variable == null)
			 */
			allGenericModels = (List<GenericModel>)TrackerCache.getInstance().getObject(AllConstants.CACHE_MARKET_ALL);
			if (! (allGenericModels != null)) {
				allGenericModels = genericModelDAO.getAll(dabaseTableName);
				TrackerCache.getInstance().addObject(AllConstants.CACHE_MARKET_ALL,allGenericModels);
			}
			dataResult = new DataResult<String>();
			dataResult.data = Utility.getInstance().toJson(allGenericModels);
			dataResult.isSuccess=true;
			
		}
		
		return dataResult;
	}

}
