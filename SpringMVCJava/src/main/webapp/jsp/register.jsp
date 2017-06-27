<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>
</head>
<body>
	<center>

		<h2>Register Here!</h2>

		<form action="createUser" method="post">
			<table>
				<tr>
					<td>Username :</td>
					<td><input type="text" name="username">
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Age :</td>
					<td><input type="text" name="age"></td>
				</tr>
				<tr>
					<td>Phone Number :</td>
					<td><input type="text" name="phone"></td>
				</tr>

				<tr>
	</table>
	<br>
					<center><table><tr><td><input type="submit" value="Register"></td></tr></table></center>
			
			
		</form>
	
	<div style="color: red;">

		<%
			System.out.println(request.getAttribute("error"));
			if (request.getAttribute("error") != null) {
				ArrayList<String> list = (ArrayList<String>) request.getAttribute("error");
				System.out.println(list);
				for (int i = 0; i < list.size(); i++) {
		%>
		<p><%=list.get(i)%></p>

		<%
			}
			}
		%>

	</div>
	</center>
</body>
</html>