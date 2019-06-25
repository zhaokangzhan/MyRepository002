package com.web;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MySessionListener implements HttpSessionBindingListener {
	   public static int num;  
	   
	  
	    public void valueBound(HttpSessionBindingEvent event) {  
	        // event.getSession().getAttribute("mListener");  
	        num++;  
	        
	        System.out.println("当前在线人数：" + num);  
	    }  
	  
	 
	    public void valueUnbound(HttpSessionBindingEvent event) {  
	        num--;  
	        System.out.println("当前在线人数：" + num);  
	    } 
	    
	  
	    
	}  
