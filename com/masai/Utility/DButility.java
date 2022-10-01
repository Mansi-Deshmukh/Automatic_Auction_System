package com.masai.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButility {
	
	// database utility class to provide jdbs connection 
		public static Connection provideConnection() {
		
			Connection conn=null;
		
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
			String url="jdbc:mysql://localhost:3306/aas";
		
			try {
				conn= DriverManager.getConnection(url,"root","java");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;

		}
}
