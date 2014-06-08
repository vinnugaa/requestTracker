package com.tracker.service;

import java.util.List;

import com.google.gson.Gson;
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
		
		if(method.equalsIgnoreCase(AllConstants.SERVICE_MAIN_REQUEST_TYPE))
			dbTableName = AllConstants.DATABASE_TABLE_REQUEST_TYPE;
		else if(method.equalsIgnoreCase(AllConstants.SERVICE_MAIN_MARKET))
			dbTableName = AllConstants.DATABASE_TABLE_MARKET;
		else if(method.equalsIgnoreCase(AllConstants.SERVICE_MAIN_BU))
			dbTableName = AllConstants.DATABASE_TABLE_BU;
		else if(method.equalsIgnoreCase(AllConstants.SERVICE_MAIN_IMPACTED_APP))
			dbTableName = AllConstants.DATABASE_TABLE_IMPACTED_APP;
		else if(method.equalsIgnoreCase(AllConstants.SERVICE_MAIN_REQUEST_STATUS))
			dbTableName = AllConstants.DATABASE_TABLE_REQUEST_STATUS;
		else if(method.equalsIgnoreCase(AllConstants.SERVICE_MAIN_ME_TOOL_STATUS))
			dbTableName = AllConstants.DATABASE_TABLE_METOOL_STATUS;
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataResult<String> doProcessing() {
		DataResult<String> dataResult= null;
		GenericModel model=null;
		List<GenericModel> allModels = null;
		GenericModelDAO genericModelDAO = new GenericModelDAO();
		
		model = (GenericModel)(new Gson()).fromJson(inputJson, GenericModel.class);
		String dbTableName = getDBTable(model.getType());
		
		if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_EACH)){
			model = (GenericModel)trackerCache.getObject(AllConstants.CACHE_GENERIC_MODEL + model.getId());
			if (!(model !=null)){
				model =  genericModelDAO.getEach(model, dbTableName);
			}
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
			dataResult.data = Utility.getInstance().toJson(model);
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ADD)){
			genericModelDAO.add(model, dbTableName);
			trackerCache.addObject(AllConstants.CACHE_GENERIC_MODEL+model.getId(), model);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_DELETE)){
			genericModelDAO.delete(model,dbTableName);
			trackerCache.removeObject(AllConstants.CACHE_GENERIC_MODEL+model.getId());
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_UPDATE)){
			genericModelDAO.update(model,dbTableName);
			trackerCache.addObject(AllConstants.CACHE_GENERIC_MODEL+model.getId(), model);
			dataResult = new DataResult<String>();
			dataResult.isSuccess=true;
		}else if(method.equalsIgnoreCase(AllConstants.SERVICE_METHOD_ALL)){
			//CHECK THE CACHE FIRST
			/* TODO
			 * 		I don't know if I can use (!(variable != null)), but for sure should not use (variable == null)
			 */
			allModels = (List<GenericModel>)trackerCache.getObject(AllConstants.CACHE_GENERIC_MODEL+AllConstants.CACHE_ALL);
			if (! (allModels != null)) {
				allModels = genericModelDAO.getAll(dbTableName);
				trackerCache.addObject(AllConstants.CACHE_GENERIC_MODEL+AllConstants.CACHE_ALL,allModels);
			}
			dataResult = new DataResult<String>();
			dataResult.data = Utility.getInstance().toJson(allModels);
			dataResult.isSuccess=true;
		}
		return dataResult;
	}

}
