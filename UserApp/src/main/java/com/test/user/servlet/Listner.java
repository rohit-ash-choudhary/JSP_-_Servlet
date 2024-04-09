package com.test.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Listner
 * 
 *  Servlet listener is a servlet method or function that awaits the occurrence of an event.
Servlet Listeners are classes that monitor a specific type of event and activate functionality when that event happens.
Servlet Listener works for listening to events in web containers like a session is created, an attribute is inserted into a session, or a container is activated
 * 
 * Servlet Listener is used for listening to events in web containers, 
 * such as when you create a session, insert an attribute, passivate and activate in another container. 
 * The servlet container generates events that trigger the action of event listener classes.
 * 
 * 
 * Event Handling in web application.
 *  so our application can handle that event take approrite action.
 *  event can we request creation and request destroyer 
 *  session created and destroyer or context is loaded and unloaded. and asnyc events.
 *  
 *  to create the listener we will implement the httpSessionListner interface.
 *  
 *  like if you want to count no of active user in session the implement the httpSessionListner and override the method.
 *  once we implement this inteface we need to tell container about listener what to do with this using annotation.
 *  and we can configure in web.xml 
 *  @WebListener 
 *  
 *  <web-app>
……
<listener>
<listener-class> Name of the class Listener</listener-class>
</listener>
……
</web-app>

When container start its scan if any of class is marked with this annotation or mapped in web.xml if then container register the 
Listener and when event start happening when its create a request and it create a session.
 */
public class Listner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
