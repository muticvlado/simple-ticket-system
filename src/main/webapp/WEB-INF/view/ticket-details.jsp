<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<h1>Ticket's Details</h1>
<hr>
<a href="/ticket/note/add?id=${ticket.id}">Add note</a>
<c:if test="${ticket.noteCount > 0 && ticket.close_date_time == null}">
	<a href="/ticket/note/close?id=${ticket.id}">Close note</a>
</c:if>
<a href="/">Back to Tickets</a>

<div class="title"><br>
	<span>Vreme: ${ticket.date_time}</span>
	<hr>
	<span>Broj: ${ticket.number}</span>
	<hr>
	<span>Otvorio: ${ticket.user.username}</span>
	<hr>
	<span>Pumpa: ${ticket.client.name}</span>
	<hr>
	<span>Naslov: ${ticket.title}</span>
	<hr style = " border-top: 3px solid red;">
	<span>Prijava: ${ticket.note}</span>
	<hr style = " border-top: 3px solid red;">
</div>
<h3>Beleske</h3>
<table>	
	<c:forEach items="${ticket.notes}" var="note">
		<c:if test="${ticket.close_date_time == null || ticket.close_date_time >= note.date_time}">
			<tr>
				<td>${note.date_time}</td>
				<td>${note.user.username}</td>						
				<td>${note.text}</td>			
			</tr>	
		</c:if>		
	</c:forEach>
</table>

<c:if test="${ticket.noteCount > 0}">
	<h3>Naknadno</h3>
	<table>	
		<c:forEach items="${ticket.notes}" var="note_ex">
			<c:if test="${ticket.close_date_time < note_ex.date_time}">
				<tr>
					<td>${note_ex.date_time}</td>
					<td>${note_ex.user.username}</td>						
					<td>${note_ex.text}</td>			
				</tr>
			</c:if>		
		</c:forEach>
	</table>
</c:if>
</body>
</html>