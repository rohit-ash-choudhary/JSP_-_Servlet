package com.test.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class InterServletCommunication:
 * we don't put all code in one Servlet or JSP , we declare many servlet and JSP.
 * and these Servlet and JSP communicated internally called InterServletCommunication or requestDispatching.
 * 
 * Like Home Page : Cart, whishist , order , product details.
 * 
 * 
 * for InterServletCommunication we use RequestDispatcher interface.
 * 
 * RequestDispatcher rd=reuqest.getRequestDispatcher(uri)
  *
  **
  *
  ** there is two way of RequestDispatcher :
  *Forward :
  *     rd.forward(request,response)
  *     in this request come from client and then servlet1 work on that and its forward to next servlet2. and once servlet2
  *     completed their work its forward to next.
  *     servlet 1 sent responce to servlet2 and servlet2 do some work then sent responce to client 
  *     
  *Include :
  *       rd.include(request,response)
  *       in this request come from client and then request come servlet1 and servlet2 (or servlet1 sent request to servlet2)
  *       but in end servlet1 and servlet2 merge the responce and sent to clinet. called include.
  *
  *
  *USE Case of interservlet comminication :
  *   login.html : loginservlet : home page
  *   
  *   in login page enter email and password then loginservlet check detail with respect database if its correct then sent to 
  *   home page else if password wrong then its sent back to responce in form include.html
  *
  *
  *
  *
  *
  *
  *
  */
public class InterServletCommunication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterServletCommunication() {
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
