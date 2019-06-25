package com.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB{
	// 定义SQLServer的数据库驱动程序
	
		public static Connection getconnect() {
			String url = "jdbc:mysql://localhost:3306/userdb";
			String username = "root";
			String password = "root";
			Connection conn = null ;
			   try {
			     Class.forName("com.mysql.jdbc.Driver");         //加载数据库驱动
			     System.out.println("数据库加载成功");
			   }
			   catch (Exception e) {
				   e.printStackTrace() ;
			     System.out.println("数据库加载失败");
			   }
			   
			   try {
				      conn = DriverManager.getConnection(url, username, password);
				      System.out.println("数据库连接成功");

				    }
				    catch (Exception e) {
				    	e.printStackTrace() ;
				      System.out.println("数据库连接失败");
				    }
			return conn;
			 }

		
}
