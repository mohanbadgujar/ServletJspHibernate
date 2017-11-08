package com.bridgelabz.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.ValidateDao;
import com.bridgelabz.model.User;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();
		
		// Reading Text Fields values and set to model
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		// Check user is valid then go to welcome page
		if (ValidateDao.authenticateUser(user)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getEmail());
			response.sendRedirect("welcome");
			
		} else// Go to Login Page
		{
			System.out.println("Sorry, username or password error!");
			request.setAttribute("error", "Invalid Username or Password");
			
			RequestDispatcher rd = request.getRequestDispatcher("login");
			rd.forward(request, response);
		}
	}
}
