<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorHandler.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
  String a = "anc";
  int num;
  try {
    num = Integer.parseInt(a);
  } catch (NumberFormatException e) {
    // Handle the NumberFormatException
    // You can redirect to error page or display an error message here
    e.printStackTrace(); // Print stack trace for debugging
  }
%>
</body>
</html>