package com.ltts.ProductionDB.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class myConfig {
	
	public static Connection getConnection() throws Exception {
		
		final String database = "jdbc:mysql://localhost:3306/dps_java_db";
		final String username = "root";
		final String pwd = "root";
		Connection c = DriverManager.getConnection(database,username,pwd);
		return c;
	}

}
