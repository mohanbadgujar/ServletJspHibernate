package com.bridgelabz;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("HI");
		
		ServletContext context=getServletContext();  
		Enumeration<String> e=context.getInitParameterNames();  
		      
		String str="";  
		while(e.hasMoreElements()){  
		   str=e.nextElement();  
		   System.out.println("Parametes are = "+context.getInitParameter(str));  

	}
  }
}
