package com.tracker.utils;

import java.lang.reflect.Method;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.google.gson.Gson;
import com.tracker.constants.AllConstants;
import com.tracker.database.DBUtils;


public class Utility {

	private static Utility utils = new Utility();
	
	public static Utility getInstance(){
		return utils;
	}
	
	public Object reflector(Object source, Object destination){
		try {
			
			Method[] allGetters = source.getClass().getDeclaredMethods();
			String getterName;
			Class[] argTypes = new Class[] { String.class };
			
			for(Method eachGetter : allGetters){
				getterName = eachGetter.getName();
				if(getterName.startsWith("get")){
					destination.getClass().getDeclaredMethod(getterName.replaceFirst("get", "set"), argTypes).invoke(destination, eachGetter.invoke(source, null));
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return destination;
	}
	
	public String toJson(Object o){
		return (new Gson()).toJson(o);
	}
	
	public Date getSQLDate(String inDate, String format){
		SimpleDateFormat formatter;
		java.util.Date utilDate = new java.util.Date();
		Date sqlDate = null;
		try{
			if(! inDate.equalsIgnoreCase(AllConstants.EMPTY_STRING)){
				formatter= new SimpleDateFormat(format);
				utilDate = formatter.parse(inDate);
			}
			sqlDate = new Date(utilDate.getTime());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return sqlDate;
		//return (new Date(new java.util.Date().getTime()));
		
	}
	public boolean notNull(Object object){
		if(object != null)
			return true;
		return false;
	}
	public Array stringToArrayconvertor(String blah, Connection conn) throws SQLException,ClassNotFoundException{
		StringTokenizer token;
		Array sqlArray =null ;
		List<Integer> blahList = new ArrayList<Integer>();
		
		token = new StringTokenizer(blah, AllConstants.DELIMITER);
		while(token.hasMoreTokens()){
			blahList.add(Integer.parseInt(token.nextToken()));
		}
		sqlArray = conn.createArrayOf("INTEGER", blahList.toArray(new Integer[blahList.size()]));
		return sqlArray;
	}
}
