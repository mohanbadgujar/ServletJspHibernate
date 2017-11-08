package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bridgelabz.model.User;

public class ValidateDao {
	
	public static boolean authenticateUser(User user) {

		boolean st = false;
		try {

			System.out.println("email::"+user.getEmail()+" pass::"+user.getPassword());
			
			//step1 : load drivers for MySql 
			Class.forName("com.mysql.jdbc.Driver");
			
			//step2 : create  the connection object  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/To_Do", "root",
					"bridgeit");

			//step3 : create the statement object  
			Statement stmt = con.createStatement();

			//step4 : execute query  
			String sql = "select * from User_Details Where email='"+ user.getEmail() +"' and password='"+ user.getPassword() +"'";
		
			ResultSet rs = stmt.executeQuery(sql);
		
			//check is any data in ResultSet 
			while(rs.next()) 
			{
				st = true;
				return st;
			}
			 
			//step5 : close the connection object 
			con.close();  
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}
