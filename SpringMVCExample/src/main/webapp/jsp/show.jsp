<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="crudOperation.user.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
	<center>
		<h2>User Details</h2>
		<%
			if (request.getAttribute("user") != null) {
				User username = (User) request.getAttribute("user");
		%>
		<h4>Username  :
		<%=username.getUsername()%></h4>
		<h4>Email :
		<%=username.getEmail()%></h4>
		<h4>Age :
		<%=username.getAge()%></h4>
		<h4>Phone :
		<%=username.getPhone()%></h4>

		<%
			}
		%>
	</center>
</body>
</html>