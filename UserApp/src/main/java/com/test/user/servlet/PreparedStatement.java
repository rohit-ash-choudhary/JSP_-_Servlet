package com.test.user.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
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
import java.util.Enumeration;



/**
 * PreparedStatment :
 * It is child interface of Statement interface in JDBC API. its precompiled version
 * of sequel statement.
 * 
 * How statement work :
 * select * from employee where employee_id=1
 * insert into employee values(1,"rohit")
 * 
 * First JDBC client sent these statement to one at time to database through database.
 * database first compile these statement if its okay syntaxlly then its excute the statment 
 * and sent back to client with appropriate result.
 * if you have 20 records to insert  then this "insert into employee values(1,"rohit")"  statement compile 20 times
 * and degrade the application functionality. because enterprise application insert millions of record
 * everyday .
 * Thats why PreparedStatement come in picture.
 * how to create prepared statement
 * PreparedStatement stmt=con.prepareStatement("");
 * we can pass entire sql in quote that we want to execute multiple time.
 * 
 * 
 *insert into employee values(?,?);
 *
 *later we can set value by setInt, setString, setFloat.
 *
 *here we once compile the query and adding parameter every time by etInt, setString, setFloat its spped up the applicaiton.
 *as single time complication.
 *
 *
 * 
 * 
 * 
 * 
 * 
 * 
 */
/**
 * PreparedStatment :
 * It is child interface of Statement interface in JDBC API. its precompiled version
 * of sequel statement.
 * 
 * How statement work :
 * select * from employee where employee_id=1
 * insert into employee values(1,"rohit")
 * 
 * First JDBC client sent these statement to one at time to database through database.
 * database first compile these statement if its okay syntaxlly then its excute the statment 
 * and sent back to client with appropriate result.
 * if you have 20 records to insert  then this "insert into employee values(1,"rohit")"  statement compile 20 times
 * and degrade the application functionality. because enterprise application insert millions of record
 * everyday .
 * Thats why PreparedStatement come in picture.
 * how to create prepared statement
 * PreparedStatement stmt=con.prepareStatement("");
 * we can pass entire sql in quote that we want to execute multiple time.
 * 
 * 
 *insert into employee values(?,?);
 *
 *later we can set value by setInt, setString, setFloat.
 *
 *here we once compile the query and adding parameter every time by etInt, setString, setFloat its spped up the applicaiton.
 *as single time complication.
 *
 *
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class PreparedStatement extends HttpServlet {
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
		   con=DriverManager.getConnection(config.getInitParameter("dbUrl"),config.getInitParameter("dbUser"),config.getInitParameter("dbPassword"));
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
