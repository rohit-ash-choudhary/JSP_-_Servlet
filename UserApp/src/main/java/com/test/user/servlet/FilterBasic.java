package com.test.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FilterBasic
 * 
 * Filter is basically java class that intercept the request and  response cycle of a servlet , any logic we want to
 * execute before the servlet request is procced by the servlet can be put in filter that is pre-processing filter.
 * 
 * any logic you want to execute before servlet responce go to back to client is post-processing filter.
 * 
 * Like XSS blocking filter.
 * 
 * in filter chaining we can apply one or more filter to servlet or a JSP.
 * 
 *  Client - (filter1- filter 2 - Servlet JSP) these all three inside container 
 *  
 *  
 *  we can map in web.xml or annotation use @Filter
 *  
 *  Lifecycle of filter is same as Servlet 
 *  
 *  Init Filter(FilterConfig config){}
 *  
 *  doFilter(ServletRequest request, ServletResponce responce, FilterChain chain){}
 *  
 *  destory(){}
 */

@WebServlet("/FilterBasicServlet") 
public class FilterBasic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print("from the servlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
