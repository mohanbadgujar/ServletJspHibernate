package com.bridgelabz.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebFilter("/AuthFilter")
public class AuthFilter implements Filter {

	FilterConfig filterConfig = null;
	 
	public void destroy() {
	}
 
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		// Returns the current session associated with this request, or if the request
		// does not have a session, creates one.
		HttpSession session = req.getSession();
		
		System.out.println("Welcome Filter Called");

		// Check session is null then goto login page
		if (session != null) {

			String name = (String) session.getAttribute("name");

			// check user exists then goto welcome page
			if (name != null) {
				
				System.out.println("Welcome " + name);
				//res.sendRedirect("welcome");
				chain.doFilter(request, response);
			} else {
				
				System.out.println("Please login first");
				res.sendRedirect("login");
			}
		} else {
			
			System.out.println("Please login first..!");
			res.sendRedirect("login");
		}
	
	}
 
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
