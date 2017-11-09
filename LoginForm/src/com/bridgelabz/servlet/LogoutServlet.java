package com.bridgelabz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.dao.DataSourcesPools;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();*/

		HttpSession session = request.getSession(false);
		session.removeAttribute("name");
		session.invalidate();
		
		//close connection object
		DataSourcesPools.closeConnection();
		
		response.sendRedirect("login");
		
	}
}
