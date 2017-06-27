<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="java.util.*"%>
<%@page import="crudOperation.user.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Portal</title>
</head>
<body>
	<center>
		<h1>Welcome to the Portal</h1>
		<form method="post" action="/SpringMVCJava/jsp/register.jsp">
			<input type="submit" value="Create User">
		</form>
		<br/><br/>
		<form  method="post" action="/SpringMVCJava/jsp/upload" enctype="multipart/form-data">
		<input type="file" name="file"/>
		<input type="submit" value="Upload">
		</form>
		<br> <br> <br>
		<table border="1">
		<tr>
			<%
			
				if (request.getAttribute("userMap")!= null) {
					
					
					List<User> hs = (List<User>)request.getAttribute("userMap");
					System.out.println(hs);
					for(User temp:hs){
						
						//User temp=entrySet.getValue();
						System.out.println(temp);
						String user=temp.getUsername();
						%>
			<tr>			
			<td><%=temp.getUsername()%></td>
			<td><%=temp.getEmail()%></td>
			<td><%=temp.getAge()%></td>
			<td><%=temp.getPhone()%></td>
			
			<td><form action="/SpringMVCJava/jsp/read/user/<%=temp.getUsername() %>" method="get">
			<input type="submit" value="Read">
			</form></td>
			
			
			<td><form action="/SpringMVCJava/jsp/find/user/<%=temp.getUsername() %>" method="get">
			<input type="submit" value="Update">
			</form></td>
			
			<td><form action="/SpringMVCJava/jsp/delete/user/<%=temp.getUsername() %>" method="get">
			<input type="submit" value="Delete">
			</form></td>
			
			
			
			</tr>
			<%
						

					}

				}
			%>
		</table>
	</center>
</body>
</html>