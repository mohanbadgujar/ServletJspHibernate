package com.bridgelabz.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourcesPools {

	static ComboPooledDataSource ds = null;
	
	private static void init() {
		
		if(ds == null) {
			
			ds = new ComboPooledDataSource();
			try {
				
				ds.setDriverClass("com.mysql.jdbc.Driver");
				ds.setJdbcUrl("jdbc:mysql://localhost:3306/To_Do");
				ds.setUser("root");
				ds.setPassword("bridgeit");
				ds.setMinPoolSize(5);//maintain 5 connection ready if its 0 then connection close after some idle time.
				ds.setAcquireIncrement(5);//if 5 connection is used then it will ready another 5 connection.
				ds.setMaxPoolSize(5);// by default 100 but if we set 5 then it allows for 5 connection only.

			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static Connection getConnection() throws SQLException
	{
		System.out.println("Inside connection");
		init();
		return ds.getConnection();
	}
	
	public static void closeConnection() 
	{
		ds.close();
	}
}
