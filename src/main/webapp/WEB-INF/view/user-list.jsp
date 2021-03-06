<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css" />
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Users</h1>
<hr>
<a href="/user/add">Add new</a><br><br>
<table>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.username}</td>	
			<td>${user.role}</td>		
			<td><a href="/user/edit?id=${user.id}">Update</a> | <a href="/user/delete?id=${user.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>