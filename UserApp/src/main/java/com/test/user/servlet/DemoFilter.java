package com.test.user.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet Filter implementation class DemoFilter
 */

@WebFilter("/*")
public class DemoFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	//sprivate static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
        // here we can write anything we want encryption decyription before request.
		// pass the request along the filter chain
		PrintWriter out = response.getWriter();
		out.print("pre servlet");   
		chain.doFilter(request, response);
		out.print("post servlet");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
