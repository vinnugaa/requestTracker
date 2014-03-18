package com.tracker.utils;

import java.util.HashMap;
import java.util.Map;

import com.tracker.constants.AllConstants;

public class Sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String>tableMap = new HashMap<String, String>();
		tableMap.put(AllConstants.DATABASE_TABLE_USER, " ( userid VARCHAR IDENTITY, name VARCHAR(50), role VARCHAR(20), password VARCHAR(20) )");
		tableMap.put(AllConstants.DATABASE_TABLE_PROJECT_ID, " ( id VARCHAR(10), description VARCHAR(100), active BOOLEAN, PRIMARY KEY(id) )");
		tableMap.put(AllConstants.DATABASE_TABLE_REQUEST_TYPE, " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )");
		tableMap.put(AllConstants.DATABASE_TABLE_MARKET, " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )");
		tableMap.put(AllConstants.DATABASE_TABLE_BU , " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )");
		tableMap.put(AllConstants.DATABASE_TABLE_IMPACTED_APP , " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )");
		tableMap.put(AllConstants.DATABASE_TABLE_REQUEST_STATUS , " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )");
		tableMap.put(AllConstants.DATABASE_TABLE_METOOL_STATUS , " ( id VARCHAR(10) IDENTITY, name VARCHAR(50) )");
		tableMap.put(AllConstants.DATABASE_TABLE_WORL_LOG , " ( id VARCHAR(10) IDENTITY, request_id VARCHAR(10), log_date DATE, log LONGVARCHAR )");
		System.out.println(tableMap.get(AllConstants.DATABASE_TABLE_WORL_LOG));
		System.out.println(tableMap.get("pramod"));
		System.out.println(tableMap.get(AllConstants.DATABASE_TABLE_WORL_LOG));
		System.out.println("Testing");
	}

}
