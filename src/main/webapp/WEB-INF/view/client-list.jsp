<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css" />
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Clients</h1>
<hr>
<a href="/client/add">Add new</a><br><br>
<table>
	<c:forEach items="${clients}" var="client">
		<tr><td>${client.code}</td><td>${client.name}</td><td><a href="/client/edit?id=${client.id}">Update</a> | <a href="/client/delete?id=${client.id}">Delete</a></td></tr>
	</c:forEach>
</table>
</body>
</html>