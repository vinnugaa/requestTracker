package com.tracker.cache;

import org.apache.jcs.JCS;

public class TrackerCache {
	
	private static JCS jcs;
	private static TrackerCache cache = new TrackerCache();
	public TrackerCache(){
		try {
			jcs = JCS.getInstance("trackerCache");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static TrackerCache getInstance(){
		return cache;
	}
	
	public void addObject(String id, Object obj){
		try {
			jcs.put(id, obj);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Object getObject(String id){
		try {
			return jcs.get(id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public void removeObject(String id){
		try{
			jcs.remove(id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
