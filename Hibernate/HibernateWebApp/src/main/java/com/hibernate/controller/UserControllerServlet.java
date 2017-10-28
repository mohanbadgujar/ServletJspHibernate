package com.hibernate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hibernate.dao.UserDAO;

public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		 String name = request.getParameter("name");
		 String email = request.getParameter("email");
		 String pass = request.getParameter("pass");
		 String mobile = request.getParameter("mobile");
		 String city = request.getParameter("city");
		 
		 try {	
			 UserDAO userDAO = new UserDAO();
			 userDAO.addUserDetails(name, pass, email, mobile, city);
			 response.sendRedirect("welcome.jsp");
		 }catch(Exception e){
			 
			 e.printStackTrace();
		 }

	}

}
