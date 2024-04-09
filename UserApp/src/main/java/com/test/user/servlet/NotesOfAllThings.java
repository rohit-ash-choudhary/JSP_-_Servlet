package com.test.user.servlet;


/**
 
	 JDBC have four componets :

JDBC API : this is provide by jdbc , its part of java.sql package.  its provide many interfaces and class like connection, 
statement, Resultset ect.
we Use these class and interface inside JDBC client code to connect with jdbc driver and and then use that driver to
perform operation against database.

JDBC DRIVER : There is different driver for different database.
its a interface between java application and database , most of time Driver written in java and its implement jdbc API under java specification.
take instruction from us establish database connection and then excute statement against database 

JDBC Client : Its is program/aaplication that we develop , 
follow these step :
1.its first connect with DB and 
2. perfrom CRUD operation using SQL statement 
3. Process the responce , number for row impacted or number of row fetch 
4. Handle and Excepetion
5. Do Transation managment 
6. Close the connection that we connect in step 1

Driver Manager : key holder and manager between API client and Driver and driver further connect with Database.
JDBC manager used once to establish connection with database , once its connected we directly connect with jdbc driver through jdbc client.
	
	
	
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
 


**
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
public class NotesOfAllThings {

}
