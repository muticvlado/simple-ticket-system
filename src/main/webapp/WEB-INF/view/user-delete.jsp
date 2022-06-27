<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>User</h1>
<hr>
<h3>Delete?</h3>	
<p>${user.id} ${user.username}</p>
<a href="/user/list">BACK</a> | <a href="/user/delete-ok?id=${user.id}">YES</a>
</body>
</html>