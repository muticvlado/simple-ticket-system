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
<h1>Client</h1>
<hr>
<h5>Delete?</h5>	
<p>${client.id} ${client.code} ${client.name}</p>
<a href="/client">BACK</a> | <a href="delete-ok?id=${client.id}">YES</a>
</body>
</html>