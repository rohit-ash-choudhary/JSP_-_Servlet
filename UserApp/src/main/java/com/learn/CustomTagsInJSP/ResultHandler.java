package com.learn.CustomTagsInJSP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.PreparedQuery;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.Tag;
import jakarta.servlet.jsp.tagext.TagSupport;

public class ResultHandler extends TagSupport {
	
	Connection con;
	PreparedStatement stmt;
	
	public ResultHandler() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver"); // This line is already present in the try block
        
        con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Rooh@#2001"); // Remove or comment out this line
      
        stmt=con.prepareStatement("select * from the user where meail=?");
	
	}
	  
	@Override
	public int doStartTag() throws JspException {
		
		ServletRequest request = pageContext.getRequest();
		String emial = request.getParameter("email");
		
		try {
			stmt.setString(1,emial);
			ResultSet rs = stmt.executeQuery();
			JspWriter out = pageContext.getOut();
			if(rs.next())
			{
				try {
					 out.print(rs.getString(1));
					 out.print(rs.getString(2));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
			}
			else {
				
				out.print("invalid email entered");
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return Tag.SKIP_BODY;
	}
	@Override
	public void release() {
		// TODO Auto-generated method stub
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
