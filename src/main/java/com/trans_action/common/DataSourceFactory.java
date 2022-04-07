package com.trans_action.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import oracle.jdbc.pool.OracleDataSource;

public class DataSourceFactory {
	
	private InputStream is = null;
	
	public DataSourceFactory() {
		String resource = "jdbc.properties";
		is = getClass().getResourceAsStream(resource);
	}
	
	public DataSource getMySQLDataSource() {
		Properties props = new Properties();
		MysqlDataSource mysqlDS = null;
		
		try {
			props.load(is);
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
			mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return mysqlDS;
	}
	
	public DataSource getOracleDataSource() {
		Properties props = new Properties();
		OracleDataSource oracleDS = null;
		
		try {
			props.load(is);
			oracleDS = new OracleDataSource();
			oracleDS.setURL(props.getProperty("ORACLE_DB_URL"));
			oracleDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));
			oracleDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
			
		} catch(IOException e) {
			e.printStackTrace();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return oracleDS;
		
	}
}
