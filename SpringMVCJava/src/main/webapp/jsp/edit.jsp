<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="crudOperation.user.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find User</title>

</head>
<body>
	<center>


		<h2>Edit Here!</h2>
		<%
			if (request.getAttribute("user") != null) {
				User user = (User) request.getAttribute("user");
		%>
		<form action="/SpringMVCJava/jsp/update/user/<%=user.getUsername()%>" method="post">
			Username :<input type="text" name="username"
				value="<%=user.getUsername()%>" readonly="readonly"><br>
			<br> Email :<input type="text" name="email"
				value="<%=user.getEmail()%>"><br> <br> Age :<input
				type="text" name="age" value="<%=user.getAge()%>"><br>
			<br> Phone Number :<input type="text" name="phone"
				value="<%=user.getPhone()%>"><br> <br> <input
				type="submit" value="Update">

			<%
				}
			%>
		</form>
	</center>
</body>
</html>