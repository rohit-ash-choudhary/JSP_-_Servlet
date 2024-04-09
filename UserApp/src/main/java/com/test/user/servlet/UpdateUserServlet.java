package com.test.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class UpdateUserServlet
 */

@WebServlet("/updateServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/* called once in all Servlet lifecycle */
	
	public void init() {
		try {
			/*
			 * con=DriverManager.getConnection("jdbc:mysql//localhost/mydb","root","Rooh@#2001");
				Statement stmt=con.createStatement();
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Rooh@#2001");
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			Statement st=con.createStatement();
			int result=st.executeUpdate("update user set email='"+email+"'");
			
	
			PrintWriter out=response.getWriter();
			if(result>0)
			out.print("<h>User update</h>");
			else {
				out.print("<h>Error in update user</h>");
			}
					
		}
		catch(SQLException e)
		{
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
