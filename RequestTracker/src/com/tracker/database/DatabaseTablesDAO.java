package com.tracker.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tracker.constants.AllConstants;

public class DatabaseTablesDAO {
	public List<String> getAllTables(){
		List<String> tables = null;
		String table = null;
		try{
			tables = new ArrayList<String>();
			ResultSet rs = DBUtils.getInstance().query("SELECT * FROM INFORMATION_SCHEMA.TABLES"); // SELECT *	FROM   INFORMATION_SCHEMA.SYSTEM_TABLES
			//int count = rs.getMetaData().getColumnCount();
			while(rs.next()){
				table = rs.getString(3);
				System.out.println(table);
				if(table.toLowerCase().contains(AllConstants.DATABASE_TABLE_PREFIX))
					tables.add(table);
				/*for (int i =1;i<=count;i++){
					System.out.println(rs.getString(i));
				}*/
			}	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tables;
	}
}
