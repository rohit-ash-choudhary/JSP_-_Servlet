package com.learn.sessionmanagent;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.connector.Response;

import jakarta.servlet.http.*;

public class SourceServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse responce) throws IOException {
		
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
		for(int i=0;i<cookies.length;i++)
		{
			System.out.println(cookies[i].getName());
			System.out.println(cookies[i].getValue());
		}
		}
		responce.addCookie(new Cookie("securityToken", "12345"));
		String userName = request.getParameter("userName");
		
		HttpSession session=request.getSession();
		session.setAttribute("user", "userName");
		responce.setContentType("text/html");
		PrintWriter out = responce.getWriter();
		String url="TargetServlet?sessionId=1234";
		out.print("<a href='"+url+"'>clieck here to get userName</a>");
		
		//http://localhost:8080/UserApp/TargetServlet?sessionId=1234
	}
	
	

}
