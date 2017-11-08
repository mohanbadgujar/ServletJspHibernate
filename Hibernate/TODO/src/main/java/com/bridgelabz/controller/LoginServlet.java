package com.bridgelabz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dao.LoginService;
import com.bridgelabz.model.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User(email, password);

		try {

			LoginService loginService = new LoginService();
			boolean result = loginService.authenticateUser(email, password);

			if (result) {
				request.getRequestDispatcher("Welcome.jsp").include(request, response);
			} else {
				System.out.println("wrong username and password");
				request.setAttribute("error", "Invalid Username or Password");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
