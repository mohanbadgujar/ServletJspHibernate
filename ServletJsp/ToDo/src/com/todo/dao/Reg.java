package com.todo.dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.model.UserModel;

import java.sql.*;

public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		UserModel userModel = new UserModel();
		
		int i = 0;
		userModel.setName(request.getParameter("name"));
		userModel.setEmail(request.getParameter("Email"));
		userModel.setPassword(request.getParameter("pass"));
		userModel.setRepassword(request.getParameter("RePass"));
		userModel.setMobile(request.getParameter("mobile"));
		userModel.setBirth(request.getParameter("dob"));
		userModel.setSex(request.getParameter("sex"));

		String name = userModel.getName();
		String Email = userModel.getEmail();
		String Pass = userModel.getPassword();
		String RePass = userModel.getRepassword();
		String mobile = userModel.getMobile();
		String dob = userModel.getBirth();
		
		String NameRegx = "^\\w+\\s{1}\\w+$";
		
		/*
		 * w - word s - space + Quantifier — Matches between one and unlimited times, as
		 * many times as possible to add more word and space = \s{1}\w+
		 */

		String EmailRegx = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

		String PassRegx = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\\s).{8,15}$";

		String MobileRegx = "^\\d{10}$";

	
		if (name.matches(NameRegx)) {

			if (Email.matches(EmailRegx)) {

				if (Pass.matches(PassRegx)) {

					if (Pass.equals(RePass)) {

						if (mobile.matches(MobileRegx)) {

							if (!dob.isEmpty()) {
								try {

									Class.forName("com.mysql.jdbc.Driver");
									Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/To_Do",
											"root", "bridgeit");

									PreparedStatement stmt = con.prepareStatement(
											"insert into User_Details(name, email, password, mobile, birth, sex) values(?,?,?,?,?,?)");
									stmt.setString(1, userModel.getName());// 1 specifies the first parameter in the query
									stmt.setString(2, userModel.getEmail());
									stmt.setString(3, userModel.getPassword());
									stmt.setString(4, userModel.getMobile());
									stmt.setString(5, userModel.getBirth());
									stmt.setString(6, userModel.getSex());

									i = stmt.executeUpdate();
									System.out.println(i + " records inserted");

								} catch (Exception e) {
									e.printStackTrace();
								}

								if (i > 0) {

									 response.sendRedirect("LoginPage.jsp");

								} else {
									response.sendRedirect("Registration.jsp");
								}

							} else {

								request.setAttribute("regerror", "Select Date of Birth..!");
								RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
								rd.include(request, response);

							}

						} else {

							request.setAttribute("regerror", "Wrong Mobile Number...!Mobile Number must have 10 Digit");
							RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
							rd.include(request, response);

						}
					} else {

						request.setAttribute("regerror", "Repeated Password not match...!");
						RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
						rd.include(request, response);

					}
				} else {

					request.setAttribute("regerror",
							"'Wrong Password...! Password must consists of at least six characters that are a combination of letters, numbers and symbols (@, #, $, %, etc.)");
					RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
					rd.include(request, response);

				}
			} else {

				request.setAttribute("regerror", "Wrong Email Format..!Email should be like abc@gmail.com");
				RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
				rd.include(request, response);

			}
		} else {

			System.out.println("Sorry, username error!");
			request.setAttribute("regerror",
					"Invalid Username..! Name must contain two words First Name and Last Name and one space between them");
			RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
			rd.include(request, response);

		}

	}
}
