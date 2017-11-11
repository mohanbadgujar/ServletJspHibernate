package com.bridgelabz.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/LoggerFilter")
public class LoggerFilter implements Filter {

	FilterConfig filterConfig = null;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Login Filter Called");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// Returns the current session associated with this request, or if the request
		// does not have a session, creates one.
		HttpSession session = req.getSession();

		String name = (String) session.getAttribute("name");
		
		String url = ((HttpServletRequest) request).getRequestURI();

		// check user exists then goto welcome page
		if (name == null) {
			
			if(url.equals("/LoginForm/welcome")) {
				
				// go to login page
				res.sendRedirect("login");
				return;
				
			}
			
			// go to login page
			chain.doFilter(request, response);
			return;
			
		}else {
			
			if(url.equals("/LoginForm/")) {
				res.sendRedirect("welcome");
				return;
			}
			
			if(url.equals("/LoginForm/welcome")) {
				
				// go to login page
				chain.doFilter(request, response);
				return;
				
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
