<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Simple ticket system</h1>

<ul>
  <li><a href="/client/">Clients</a></li>
  <li><a href="/">Tickets</a></li>
  <li><a href="/user/list" >Users</a></li>
  <li>
  	<form:form action="/logout" method="post">
    	<input type="submit" value="Logout" />
	</form:form>
  </li>
</ul>
</body>
</html>