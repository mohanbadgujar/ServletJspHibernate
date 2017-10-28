package com.todo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Returns the current session associated with this request, or if the request does not have a session, creates one.	
		HttpSession session=request.getSession(false);  
		
		//Check session is null then goto login page  
        if(session!=null){
        	
        	String name=(String)session.getAttribute("name");  
          
        	
        	//check user exists then goto welcome page
        	if (name != null) {
        		System.out.println("Welcome "+name);
            	request.getRequestDispatcher("Welcome.jsp").forward(request, response);  
			} 
        	else{  
            	System.out.println("Please login first");  
                request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
            }  
        }  
        else{  
        	System.out.println("Please login first..!");  
            request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
        } 

	}

}
