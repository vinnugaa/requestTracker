package com.tracker.cache;

import org.apache.jcs.JCS;

public class TrackerCache {
	
	private static JCS cache;
	public TrackerCache(){
		try {
			cache = JCS.getInstance("trackerCache");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static JCS getInstance(){
		return cache;
	}
	
	public void addObject(String id, Object obj){
		try {
			cache.put(id, obj);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Object getObject(String id){
		try {
			return cache.get(id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public void removeObject(String id){
		try{
			cache.remove(id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
