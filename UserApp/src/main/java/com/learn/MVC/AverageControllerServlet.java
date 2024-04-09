package com.learn.MVC;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AverageControllerServlet
 */


@WebServlet(urlPatterns="/averageController")
public class AverageControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Intger = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		int num1 = Integer.parseInt(request.getParameter("number1"));
		int num2 = Integer.parseInt(request.getParameter("number1"));
		
		averageController model=new averageController();
		int result=model.calculatpr(num1, num2);
		request.getAttribute("result"+result);
		request.getRequestDispatcher("ResultofAvargeNymber.jsp");
	}

}
