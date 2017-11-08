package com.bridgelabz.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
         
    	try {
			
    		//step1 : load drivers for MySql 
			Class.forName("com.mysql.jdbc.Driver");
			
			//step2 : create  the connection object  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/To_Do", "root",
					"bridgeit");
	
			//storing connection object as an attribute in ServletContext  
			ServletContext ctx = sce.getServletContext();
			ctx.setAttribute("connection",con);
			
			System.out.println("Connection object is created through ServletontextListener");
			
		} catch (Exception e) {
			System.out.println("Error while creating connection to database");
		}
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
       
    }
	
}
