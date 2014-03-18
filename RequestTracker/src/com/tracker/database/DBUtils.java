package com.tracker.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tracker.constants.AllConstants;

public class DBUtils {

	private static DBUtils dbconn = new DBUtils();
	
	public static DBUtils getInstance(){
		return dbconn;
	}

	public Connection connect() throws SQLException, ClassNotFoundException{
		Connection conn =null;
		Class.forName("org.hsqldb.jdbcDriver");
		conn = DriverManager.getConnection("jdbc:hsqldb:" + AllConstants.DATABASE_NAME, "pram", "");
		return conn;
	}
	public void shutdown(Connection conn)throws SQLException{
		conn.createStatement().execute("SHUTDOWN");
		conn.close();
	}
	public void update(String command) throws SQLException, ClassNotFoundException{
		Connection conn = connect();
		Statement st=null;
		st = conn.createStatement();
		System.out.println("command:: "+command);
		int i = st.executeUpdate(command);
		if(i==-1){
			System.out.println("ERROR !! ::" + command);
		}
		st.close();
		shutdown(conn);
	}
	public synchronized ResultSet query(String command) throws SQLException,ClassNotFoundException{
		Connection conn = connect();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(command);
		st.close();
		shutdown(conn);
		return rs;
	}
	// TODO: handle exception
	// MODIFY THE IMPLEMENTATION AS PER : http://www.java2s.com/Code/JavaAPI/java.sql/DatabaseMetaDatagetTablesStringcatalogStringschemaPatternStringtableNamePatternStringtypes.htm
	
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
	/*** 
	 * GENERIC OPERATIONS
	 * @param tableName
	 * 
	 */
	
	
	/** 
	 * 
	 * USER TABLE OPERATIONS 
	 * 
	 * **/
	
}
