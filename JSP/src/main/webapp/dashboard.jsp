<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="Servelet.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>jspdashboard</title>
</head>
<body>


	<%
	User user=(User)session.getAttribute("user");
	%>
	
	
	Hello<%=user.getUsername() %>
	
	<br>
	Mobo=<%=user.getMobo() %>
	
	<br>
	Address=<%=user.getAddress() %>
	<br>
	Dob=<%=user.getDob() %>
    

</body>
</html>