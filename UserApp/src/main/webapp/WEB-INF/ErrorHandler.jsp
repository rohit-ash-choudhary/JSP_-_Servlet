<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<p> Sorry, An Error has occured </p>
<%=exception.getMessage() %>
</body>
</html>