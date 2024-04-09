package com.test.user.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
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
 * Servlet implementation class CreateUserServlet
 */

@WebServlet(urlPatterns="/aaaddServlet",initParams= {@WebInitParam(name="dburl",value="com.mysql.cj.jdbc.Driver"),
@WebInitParam(name="dbUser",value="root"),@WebInitParam(name="dbPassword",value="Rooh@#2001")})
public class UseInitParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/* called once in all Servlet lifecycle */
	
	public void init(ServletConfig config) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection(config.getInitParameter("dburl"),config.getInitParameter("dbuser"),config.getInitParameter("dbPassword"));

			
			//  con=DriverManager.getConnection("jdbc:mysql//localhost/mydb:3306","root","Rooh@#2001");
				Statement stmt=con.createStatement();
			
	        //con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Rooh@#2001");
			// con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Rooh@#2001");
	        System.out.println(con);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
		    Statement st = con.createStatement();
		    
		    int result = st.executeUpdate("INSERT INTO user VALUES ('" + firstname + "', '" + lastname + "', '" + email + "', '" + password + "')");
		    

		    PrintWriter out = response.getWriter();
		    if (result > 0)
		        out.print("<h>user created</h>");
		    else {
		        out.print("<h>Error in create user</h>");
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
