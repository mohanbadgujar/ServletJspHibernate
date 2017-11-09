package com.bridgelabz.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.dao.SaveUserDao;
import com.bridgelabz.model.User;
import com.bridgelabz.validation.UserBackEndValidation;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	User user = new User();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

		// save data to user model
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("Email"));
		user.setPassword(request.getParameter("pass"));
		user.setRepassword(request.getParameter("RePass"));
		user.setMobile(request.getParameter("mobile"));
		user.setBirth(request.getParameter("dob"));
		user.setSex(request.getParameter("sex"));

		UserBackEndValidation validation = new UserBackEndValidation();

		// Check user backEnd validation
		String isError = validation.checkValidation(user);
		
		//Get connection object from servlet context listener
		ServletContext servletContext = getServletContext();

		// Save user data if no backEnd validation error
		if (isError == null) {

			// Save user to database
			SaveUserDao saveUser = new SaveUserDao();
			Boolean isUserSaved = saveUser.saveUser(user,servletContext);

			if (isUserSaved) {
				
				response.sendRedirect("login");

			} else {

				RequestDispatcher rd = request.getRequestDispatcher("registration");
				rd.forward(request, response);
			}

		} else {

			// print appropriate error message
			request.setAttribute("regerror", isError);
			RequestDispatcher rd = request.getRequestDispatcher("registration");
			rd.forward(request, response);

		}

	}

}
