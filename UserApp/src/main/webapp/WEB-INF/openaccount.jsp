<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="openaccount.html" %>
  <%! Connection con;
    PreparedStatement ps;
    public void jspInit(){
    	try{
        Class.forName("com.mysql.cj.jdbc.Driver");
    	con=DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Rooh@#2001");
    	ps=con.prepareStatement("insert into account values(?,?,?,?)");
    	}
    	catch (Exception e)
    	{
    	   e.printStackTrace();
    	}
    }
    public void jspDestroy(){
    	try{ps.close();
    	con.close();
    	}catch (Exception e)
    	{
    	   e.printStackTrace();
    	}
    }
    %>
    
    <% 
    
     int accno=Integer.parseInt(request.getParameter("accno"));
    String lastname=request.getParameter("lastname");
    String firstname=request.getParameter("firstname");
    int bal=Integer.parseInt(request.getParameter("bal"));
    
    ps.setInt(1, accno);
    ps.setString(2,lastname);
    ps.setString(3,firstname);
    ps.setInt(4,bal);
    
    ps.executeUpdate();
    
    
    %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Open Account</title>
</head>
<body>

</body>
</html>

