package com.trans_action.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

public class JDBCUtil {
	private static final String driverName = "com.mysql.cj.jdbc.Driver";
	private static final String jdbcUrl = "jdbc:mysql://localhost:3306/ssm";
	private static final String userId = "root";
	private static final String userPwd = "1234";
	
	public static Connection getConnection() {
		try {
			
			Class.forName(driverName);
			return DriverManager.getConnection(jdbcUrl, userId, userPwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if(stmt != null) {
			try {
				if(!rs.isClosed())
					rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		} //end of it
		
		if(stmt != null) {
			try {
				if(!stmt.isClosed())
					stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		} //end of it
		
		if(conn != null) {
			try {
				if(!conn.isClosed())
					conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			} 
		} //end of it
		
	}
}
