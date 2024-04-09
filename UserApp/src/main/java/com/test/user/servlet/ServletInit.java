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

 *
 * Servlet Init Parameneters : init paramenters are value pair of actaull information , thats supply 
 * to servlet declartivly raised through web.xml in key : value pair (supply to servlet during its
 * Intilization phase)
 * 
 * key and value is simply filename and dbname or dbpasswords 
 * 
 * 
 *<servlet>
        <servlet-name>redteam</servlet-name>
       <servlet-class>mysite.server.TeamServlet</servlet-class>
       <init-param>
            <param-name>dbusername </param-name>
            <param-value>DB Password</param-value>
        </init-param>
        <init-param>
            <param-name>bgColor</param-name>
            <param-value>#CC0000</param-value>
        </init-param>
    </servlet>
 *
 *
 *  Servlet container pass the value to servlet using init method init(ServletConfig config)
 *  this init store the value in ServletConfig object and 
 *  in servlet class you can esaily reterive the value by getParameter method
 *  String dbuser=config.getParameter("dbusername")
 *  
 *  you can declare any number of init parameter 
 *  
 *  Advantages : there is no haedcoded value in servlet as dbpassword change every time you no need to change
 *  servlet and re-compile and deploy.
 *  
 *  
 *  Configure Init Parameter by Annotation : 
 * 
 *  WebServlet(urlPatterms="/updateServlet",initParams=@WebInitParam(name='dburl',value=""jdbc:mysql//localhost/mydb"",
 *  @WebInitParam(name='dbuser',value="root"),@WebInitParam(name="dbPassword,value="Rooh@#2001'))
 *
 *
 *
 *
 * Servlet  Context :
 * Servlet context object is application level object (Shared Data)
 * 
 * Servlet context is library interface in ServletAPI used in JAVAX servlet page.
 * 
 * Container implement this interface as soon as we deploy our application (even before any clinet 
 * request come Servlet Container create Serlvet context)
 * There is only one servlet context for entire application, we can destory servlet context and undeploy our application.
 * 
 * Data we put in Servlet context is accesible by all jsp in our application
 * 
 * Container inject the the servlet context in servlet. we can access in different way
 * 
 * for init method with Config.
 *  
 *  Public void init(ServletConfig config)
 *  {
 *  
 *  ServletContext context=config.getServletContext();
 *  }
 * 
 * 
 * init method wihtout config:
 * 
 * pulic void init(){
 * ServletContext context=getServletContext();
 *  setServletContext already called by container before we call getServletContext
 *  }
 *  
 *  
 *  public void service(){
 *  
 *  ervletContext context=getServletContext();
 *  }
 *
 *
 *
 *
 *
 * Used of Servlet Context :
 * 1. Share and Maniplute Data at application level :
 * we can set data in any servlet and get in another servlet. using
 * setAttribute() and GetAttribute()
 * 
 * we can also remove the data if you want remove from servlet context 
 * removeAttribute() method 
 * 
 * if you want to all attribute in servlet Context.
 * getAttribureNames()
 * 
 * 2. To deal with Context parameter :
 * 3. to create requestDispatcher object for inter-servlet communication
 * 4. to store information in to the server log files using the log method()
 * 
 * Context parameter are actaully name : value pair of information that are supplied from web.xml to our
 * application its same like
 * init-param but difference is that init-param are for particular servlet but context parameter can pass
 * to any servlet or jsp crossover application.
 * we declare in web.xml as below.
 * we use context-param keyword to set context-param
	 * <context-param>
			    <param-name>validHosts</param-name>
			    <param-value>example1.com</param-value>
			    <param-value>example2.com</param-value>
			    <param-value>example3.com</param-value>
	   </context-param>
	   
	   Contair read from the web.xml and set to servlet context it will used for whole application.
	   
	   we can access easily by
	    String driver=sc.getInitParameter("driver");
	    
	    
 * 
 * 
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

public class ServletInit extends HttpServlet {
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
		/* try {
			
			 // con=DriverManager.getConnection("jdbc:mysql//localhost/mydb","root","Rooh@#2001");
			//	Statement stmt=con.createStatement();
			  
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Rooh@#2001");
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
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
