package com.learn.JSP;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class JSPInfo
 * 
 *  JSP : Java Server Pages.
 *  
 *  This is technology in JAVA EE Space that comes with API and specification.
 *  Oracle provide these to API and specification in JSP like other technologies.
 *  API is for application Developer.
 *  
 *  Specification  : Specification its set of of rules that should be followed by the JSP content creator,
 *  these rules are followed by Apache TOMCAT and weblogicm ,Jboss.
 *  
 *  JSP working :
 *  JSP run on JSP container get request from the web client(browser) interact with database and get result and responce
 *  back to the Web client,
 *  
 *  JSP can do everthing that Servley page do.
 *  
 *  JSP OVERCOME THE SERVLET AS HTML+JAVA CODE IN JSP
 *  
 *  JSP Elements :
 *  
 *        three types of elements in JSP :
 *        1. Scripting elements : to emded java to code  into the JSP
 *        2. Directives  : Translation time instruction to the container will allow to do imports java libraries and including other 
 *        libraries.
 *        3. Action  : Run time instruction to container which allow to perform some dynamic operation at runtime
 *  
 *   
 *  JSP Life cycle :
 *          jspInit()
 *          _jspService()
 *          jspDestory()
 *          
 *          two additional phase translate and compilation then jsp :
 *           rest are instantiation , 
 *           Initliziation, : jspInit()
 *          Servicing, : _jspService()
 *           Destruction  : jspDestory()
 *        
 *        translation :
 *        
 *        When we create jsp file  ;its contain html ,java and jsp elements from JSP API,
 *        this jsp file converted when first web request come the web broswer.
 *        
 *        hello.JSP FILE -----first request come from web client --> container --->container generate the .serlvet (hello.java)
 *        
 *        the above process in which container generate the hello.jsp to hello.java  serlvet file called translation.
 *        
 *        
 *        Compilation : The servlet generate turing translation compile by Java compiler and change in Hello.class file
 *        its called Compilation.
 *        
 *         
 *         Hello.jsp ------JSP Container (transaltion)----> hello.java -------> java compiler(complilation)-----> hello.class.
 *         
 *         
 *        
 *         
 *         translatation and compilation only happend once in your jsp , if you change code then its happend again.
 *          
 *          
 *   Implicit Page :
 *                 There is 9 implicit object that are avaialbe to every JSP pages.
 *                they call implicit object becoz we don't need to explicity to use them.
 *                
 *                Config - Servlet config
 *                request - HttpServletRequest
 *                responce -HttpServletResponce
 *                Session - httpSession
 *                application - ServletContext
 *                page - java.lang.object
 *                pageContext - javax.servlet.jsp.pageContext
 *                exception - java.lang.throwble
 *                out - javax.servlet.jsp.jspWriter
 *                
 *     Scriptting Element :
 *     three type of Scriptting Element :
 *     
 *          1. Declaration : Start <%! we can write any java code%> any number of Declaration you declare in jsp 
 *          Any thing in this block will go as field level on the translator when jsp transfor to java servlet anything here
 *          has become the member variable and member method.
 *          decalre any filed or method that go at global level or servelt.
 *          only block where you can define method
 *          2. Expression :  <%=  any java code expression that evalute the value
 *          user.getName()  %>
 *          evalute the value and get back responce to back to browser
 *          3. Scriplet :  <% any number of java stament  %>
 *               if you want to put a lot of java code then this is used
 *               
 *               
 *     JSP Directive :
 *     container change jsp to java servlet using JSP Directive.
 *     The jsp directives are messages that tells the web container how to translate a JSP page into the corresponding servle
 *     
 *     There is 3 Types of Directive
 *     1.page directive
       2.include directive
       3. taglib directive
      follow this link : https://www.javatpoint.com/jsp-page-directive 
       1. page directive
        The page directive defines attributes that apply to an entire JSP page.

          Syntax of JSP page directive
             <%@ page attribute="value" %>  
         this used to import java package.
       2. include directive 
       
            The include directive is used to include the contents of any resource
             it may be jsp file, html file or text file. The include directive includes the original 
             content of the included resource at page translation
             time (the jsp page is translated only once so it will be better to include static resource).
             
             
            <%@ include file="resourceName" %>  
            
            like there is logo.hmtl you want call this in all jsp so use this tag 
 *      JSP Taglib directive
      3.JSP Taglib directive

			The JSP taglib directive is used to define a tag library that defines many tags. 
			We use the TLD (Tag Library Descriptor) file to define the tags. In the custom tag
			 section we will use this tag so it will be better to learn it in custom tag.
			 
			these tags looks like html tags but in backend they ran java code
 *     
 * 
 * */
public class JSPInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSPInfo() {
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
