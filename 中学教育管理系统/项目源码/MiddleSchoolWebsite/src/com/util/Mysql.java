package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Mysql {

	private static Properties config = new Properties();
	
	static{
		try {
			config.load(Mysql.class.getClassLoader().getResourceAsStream("sql.properties"));
			Class.forName(config.getProperty("driver"));
//			System.out.println("----"+config.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"),
				config.getProperty("password"));
//		System.out.println("----"+config.getProperty("driver"));
//		System.out.println("----"+config.getProperty("url"));
//		System.out.println("----"+config.getProperty("username"));
//		System.out.println("----"+config.getProperty("password"));
		return conn;
		
	}
	public static void release(Connection conn, Statement st, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(st != null){
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
}
