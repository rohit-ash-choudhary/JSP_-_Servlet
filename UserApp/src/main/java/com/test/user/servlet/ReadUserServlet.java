package com.test.user.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class UpdateUserServlet
 */

//@WebServlet("/readServlet")
public class ReadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private ServletResponse responce;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/* called once in all Servlet lifecycle */
	
	public void init(ServletConfig config) {
	    try {
	      Class.forName("com.mysql.cj.jdbc.Driver"); // This line is already present in the try block
	        ServletContext context = config.getServletContext();
	        System.out.println(context.getInitParameter("dbUrl"));
	        System.out.println(context.getInitParameter("dbUser"));
	        System.out.println(context.getInitParameter("dbPassword"));
	      //  Class.forName("com.mysql.cj.jdbc.Driver");
       con = DriverManager.getConnection(context.getInitParameter("dbUrl"), context.getInitParameter("dbUser"), context.getInitParameter("dbPassword"));
	        // con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Rooh@#2001"); // Remove or comment out this line
	        // con = DriverManager.getConnection(config.getInitParameter("dbUrl"), config.getInitParameter("dbUser"), config.getInitParameter("dbPassword")); // Remove or comment out this line
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    
	    //String email=request.getParameter("email");
	    //String password=request.getParameter("password");
	    try {
	        Statement st = con.createStatement();
	        ResultSet result = st.executeQuery("select * from user");
	        PrintWriter out = response.getWriter(); // Corrected variable name
	        
	        out.print("<table>");
	        out.print("<tr>");
	        out.print("<th>");
	        out.print("FirstName");
	        out.print("</th>");
	        out.print("<th>");
	        out.print("LastName");
	        out.print("</th>");
	        out.print("<th>");
	        out.print("Email");
	        out.print("</th>");
	        out.print("</tr>");
	        while (result.next()) {
	            out.print("<tr>");
	            out.print("<td>");
	            out.print(result.getString(1)); // Corrected method call
	            out.print("</td>");
	            out.print("<td>");
	            out.print(result.getString(2)); // Corrected method call
	            out.print("</td>");
	            out.print("<td>");
	            out.print(result.getString(3)); // Corrected method call
	            out.print("</td>");
	            out.print("</tr>");
	            
	        }
	        out.print("</table>");
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	}
    
	
	public void destory() throws SQLException {
		try
		{con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
