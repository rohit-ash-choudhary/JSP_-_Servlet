package com.test.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PreIntializationOfServlet:
 * 
 * 
 * There is two way of inilization of Servlet :
 * 1. Lazy inilization
 * 2. Pre inilization
 * 
 * Lazy inilization : 
 * Web Client - Container - Servlet 
 * if a servlet container intilize the servlet only when the first web client request come then its called Lazy inilization.
 * by default all the servlet are lazy inilization
 * 
 * Pre inilization :
 * If a servlet even inilization before  web client request come  its called Pre inilization.
 *  we can request the container to do pre-inilization by using load on startup element in web.xml
 *  <load-on-startup>0</load-on-startup>  
 *  
 *  as below :
 *     <servlet>  
   				<servlet-name>servlet1</servlet-name>  
   				<servlet-class>com.javatpoint.FirstServlet</servlet-class>  
   				<load-on-startup>0</load-on-startup>  
        </servlet>  
 * its take numeric value and its indicate priority of  inilization servlet which one before or which one later
 * lower the number higher the priority.
 * 
 * Exmple :
 * Web services using CFX or jersey.
 * 
 * Spring MVC Frame also used Disptacher servlet thats load as startup
 * 
 * Pre inilization using Annoatation.
 * 
 * how to initialization using web.xml 
 * 
 * <web-app>  
 ....  
  
  <servlet>  
   <servlet-name>servlet1</servlet-name>  
   <servlet-class>com.javatpoint.FirstServlet</servlet-class>  
   <load-on-startup>0</load-on-startup>  
  </servlet>  
  
  <servlet>  
   <servlet-name>servlet2</servlet-name>  
   <servlet-class>com.javatpoint.SecondServlet</servlet-class>  
   <load-on-startup>1</load-on-startup>  
  </servlet>  
  
 ...  
</web-app>
 */
//@WebServlet(urlPatterns = "/PreIntilizServ");
// Pre inilizatio using annotation  :
//@WebServlet(urlPatterns = "/PreIntilizServ", loadOnStartup = 0) // in this case this servlet called at initial after server start
public class PreIntializationOfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	 public void init() {
		  
		 System.out.println("inside the init method");
	 }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().write("pre inlization of servlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
