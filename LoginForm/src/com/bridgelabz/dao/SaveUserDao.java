package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletContext;

import com.bridgelabz.model.User;

public class SaveUserDao {

	public Boolean saveUser(User user,ServletContext servletContext) {
		
		Boolean isuserSaved = false;
		int i = 0;
		
		try {

			Connection con = (Connection) servletContext.getAttribute("connection");
			
			PreparedStatement stmt = con.prepareStatement(
					"insert into User_Details(name, email, password, mobile, birth, sex) values(?,?,?,?,?,?)");
			stmt.setString(1, user.getName());// 1 specifies the first parameter in the query
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getMobile());
			stmt.setString(5, user.getBirth());
			stmt.setString(6, user.getSex());

			i = stmt.executeUpdate();
			System.out.println(i + " records inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (i > 0) {

			isuserSaved = true;

		} else {
			
			isuserSaved = false;
		}
		
		return isuserSaved;
	}
	
}
