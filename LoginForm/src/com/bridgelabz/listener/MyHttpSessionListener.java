package com.bridgelabz.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    public void contextInitialized(HttpSessionEvent sce)  { 
         System.out.println("Http session is created");
    }
	
    public void contextDestroyed(HttpSessionEvent sce)  { 
        System.out.println("session is destroyed");
   }

}
