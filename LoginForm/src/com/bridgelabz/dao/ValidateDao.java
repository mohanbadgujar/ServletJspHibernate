package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;
import com.bridgelabz.model.User;

public class ValidateDao {
	
	public static boolean authenticateUser(User user,ServletContext ctx) {

		boolean st = false;
		try {

		   Connection con = DataSourcesPools.getConnection();
			
		/*	//Retrieving connection object from ServletContext object  
			Connection con = (Connection) ctx.getAttribute("connection");*/

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
