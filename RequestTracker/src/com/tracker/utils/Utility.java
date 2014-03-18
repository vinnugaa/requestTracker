package com.tracker.utils;

import java.lang.reflect.Method;
import java.sql.Date;

import com.google.gson.Gson;


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
	
	public Date getSQLDate(){
		return (new Date(new java.util.Date().getTime()));
	}
}
