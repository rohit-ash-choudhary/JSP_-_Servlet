package com.test.user.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




/**
 * Servlet implementation class LoginPageUser
 */
public class LoginPageUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement stmt;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) {
		try {
			
		/*	ServletContext context=config.getServletContext();
			 System.out.println("init()");
			 
			Enumeration<String> parameternames = context.getInitParameterNames();
			
			while(parameternames.hasMoreElements())	
			{
				String EachN=parameternames.nextElement();
				System.out.println("contect paramname"+ EachN);
				System.out.println("context paramvalue" + context.getInitParameter(EachN));
			}*/
		   Class.forName("com.mysql.cj.jdbc.Driver");
		//	 System.out.println("dbURL"+ config.getInitParameter("dbUrl"));
		//	 System.out.println("dbUSER"+config.getInitParameter("dbUser"));
		//	 System.out.println(config.getInitParameter("dbPassword"));
		    con=DriverManager.getConnection(config.getInitParameter("dbUrl"),config.getInitParameter("dbUser"),config.getInitParameter("dbPassword"));
			 //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Rooh@#2001");
			// System.out.println(con);
			
			//con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Rooh@#2001"); 
			// con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Rooh@#2001");
	       // System.out.println(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select * from user where email='" + userName + "' and password='" + password + "'");
			

			RequestDispatcher rd=request.getRequestDispatcher("HomeServlet");  
            if(result.next())
            {    
            	request.setAttribute("message", "welcome to interserlver comminit"+userName);
            	rd.forward(request, response);
            }
            else {
            	rd =request.getRequestDispatcher("login.html");
            	rd.include(request, response);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
