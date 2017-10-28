package com.bridgelabz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dao.RegisterService;
import com.bridgelabz.model.User;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String mobile = request.getParameter("mobile");
		String birth = request.getParameter("birth");
		String sex = request.getParameter("sex");

		User user = new User(name, email, password, repassword, mobile, birth, sex);

		try {
			RegisterService registerService = new RegisterService();
			boolean result = registerService.register(user);

			if (result) {
				request.getRequestDispatcher("index.jsp").include(request, response);

			} else {

				request.getRequestDispatcher("Registration.jsp").include(request, response);
			}

		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}
