<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body style="color: red;">
	<%
	System.out.println(request.getAttribute("error"));
	if(request.getAttribute("error")!=null)
	{
		ArrayList<String> list=(ArrayList<String>)request.getAttribute("error");
		System.out.println(list);
		for(int i=0;i<list.size();i++){
			%>
			<p><%=list.get(i)%></p>
			
			<%
		}
	}
	%>
<%-- 	<p>${error}</p> --%>
</body>
</html>