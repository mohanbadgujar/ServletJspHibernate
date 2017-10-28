package com.todo.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.todo.dao.*;
import com.todo.model.UserModel;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		UserModel usermodel = new UserModel();

		// Reading Text Fields values and set to model
		usermodel.setEmail(request.getParameter("email"));
		usermodel.setPassword(request.getParameter("pass"));

		// Check user is valid then go to welcome page
		if (Validate.checkUser(usermodel)) {
			HttpSession session = request.getSession();
			session.setAttribute("name", usermodel.getEmail());
			request.getRequestDispatcher("Welcome.jsp").include(request, response);
		} else// Go to Login Page
		{
			System.out.println("Sorry, username or password error!");
			request.setAttribute("error", "Invalid Username or Password");
			RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.jsp");
			rd.include(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
