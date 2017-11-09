package com.bridgelabz.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
	
	private static int totalSessions = 0;
	
    public void sessionCreated(HttpSessionEvent se)  { 
    	
    	 totalSessions++;
    	 System.out.println("Http session is created::ID="+se.getSession().getId());
    	 System.out.println("Total Sessins"+totalSessions);
   
    }
	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    
        System.out.println("session is destroyed::ID="+se.getSession().getId());
        System.out.println("Total Sessins"+totalSessions);
    }

}
