package com.tracker.constants;

public class AllConstants {

	//GENERIC ONES
	public static final String EMPTY_STRING = "";
	
	//DATABASE CONSTANTS
	public static final String DATABASE_NAME = "sampleDB1";
	public static final String DATABASE_TABLE_PREFIX = "sample";
	public static final String DATABASE_TABLE_USER = DATABASE_TABLE_PREFIX+ "tblUsers";
	public static final String DATABASE_TABLE_REQUEST_TYPE = DATABASE_TABLE_PREFIX + "tblRequestTypes";
	public static final String DATABASE_TABLE_MARKET = DATABASE_TABLE_PREFIX+ "tblMarkets";
	public static final String DATABASE_TABLE_BU = DATABASE_TABLE_PREFIX+ "tblBUs";
	public static final String DATABASE_TABLE_PROJECT_ID = DATABASE_TABLE_PREFIX + "tblProjectIds";
	public static final String DATABASE_TABLE_IMPACTED_APP = DATABASE_TABLE_PREFIX + "tblImpactedApps";
	public static final String DATABASE_TABLE_REQUEST_STATUS = DATABASE_TABLE_PREFIX + "tblRequestStatus";
	public static final String DATABASE_TABLE_METOOL_STATUS = DATABASE_TABLE_PREFIX+ "tblMEToolStatus";
	public static final String DATABASE_TABLE_WORL_LOG = DATABASE_TABLE_PREFIX+ "tblWorkLog";
	
	public static final String DATABASE_TABLE_USER_DESCRIPTION = " ( userid VARCHAR IDENTITY, name VARCHAR(50), role VARCHAR(20), password VARCHAR(20) )";
	public static final String DATABASE_TABLE_REQUEST_TYPE_DESCRIPTION = " ( id INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 100), name VARCHAR(50) )";
	public static final String DATABASE_TABLE_MARKET_DESCRIPTION = " ( id INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 100), name VARCHAR(50) )";
	public static final String DATABASE_TABLE_BU_DESCRIPTION = " ( id INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 100), name VARCHAR(50) )";
	public static final String DATABASE_TABLE_PROJECT_ID_DESCRIPTION = " ( id VARCHAR(10), description VARCHAR(100), active BOOLEAN, PRIMARY KEY(id) )";
	public static final String DATABASE_TABLE_IMPACTED_APP_DESCRIPTION = " ( id INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 100), name VARCHAR(50) )";
	public static final String DATABASE_TABLE_REQUEST_STATUS_DESCRIPTION = " ( id INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 100), name VARCHAR(50) )";
	public static final String DATABASE_TABLE_METOOL_STATUS_DESCRIPTION = " ( id INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 100), name VARCHAR(50) )";
	public static final String DATABASE_TABLE_WORL_LOG_DESCRIPTION = " ( id INTEGER GENERATED ALWAYS AS IDENTITY(START WITH 100), request_id VARCHAR(10), log_date DATE, log LONGVARCHAR )";
	
	public static final String USERID = "userid";
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String ROLE = "role";
	public static final String PASSWORD = "password";
	public static final String PROJECT_ID = "projectId";
	public static final String DESCRIPTION = "description";
	public static final String ACTIVE = "active";
	
	//SERVICE LOOKUPS
	public static final String SERVICE_MAIN_USER = "srvcUser";
	public static final String SERVICE_MAIN_DC = "srvcDC";
	public static final String SERVICE_MAIN_TABLES = "srvcTables";
	
	public static final String SERVICE_METHOD_VALIDATE = "srvcValidate";
	
	public static final String SERVICE_METHOD_ADD = "srvcMethodAdd";
	public static final String SERVICE_METHOD_DELETE = "srvcMethodDel";
	public static final String SERVICE_METHOD_UPDATE = "srvcMethodUp";
	public static final String SERVICE_METHOD_ALL = "srvcMethodAll";
	public static final String SERVICE_METHOD_EACH = "srvcMethodEach";
	public static final String SERVICE_METHOD_PURGE_EACH = "srvcMethodPurgeEach";
	public static final String SERVICE_METHOD_PURGE_ALL = "srvcMethodPurgeAll";
	public static final String SERVICE_METHOD_DELETE_ALL = "srvcMethodDelAll";
	public static final String SERVICE_METHOD_CREATE = "srvcMethodCreate";
	public static final String SERVICE_METHOD_CREATE_ALL = "srvcMethodCreateAll";
	
	
	
	//CACHE KEYS
	public static final String CACHE_USER_ALL = "cacheUserAll";
	public static final String CACHE_DC_ALL = "cacheDCAll";
	
}
