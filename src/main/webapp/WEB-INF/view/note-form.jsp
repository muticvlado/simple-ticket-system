<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
	<h1>Note</h1>
	<hr>
	<div class="title">
		<span>Vreme: ${note.ticket.date_time}</span>
		<hr>
		<span>Broj: ${note.ticket.number}</span>
		<hr>
		<span>Otvorio:: ${note.ticket.user.username}</span>
		<hr>
		<span>Pumpa: ${note.ticket.client.name}</span>
		<hr>
		<span>Naslov: ${note.ticket.title}</span>
		<hr>
		<span>Prijava: ${note.ticket.note}</span>
		<hr>
	</div>
	
	<form:form action="save" modelAttribute="note">
		<form:hidden path="id" />
		<form:hidden path="user"/>
		<form:hidden path="ticket"/>				
		<table>
			<tr>
				<td><form:label path="text" title="Beleska">Beleska</form:label></td>
				<td><form:textarea path="text" cols="50" rows="5" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" style="width: 50%; padding: 6px; display: block; margin: auto"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>