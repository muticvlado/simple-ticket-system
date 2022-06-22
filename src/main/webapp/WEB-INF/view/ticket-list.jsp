<%@page import="vlado.model.Note"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="vlado.service.TicketService"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
<h1>Tickets</h1>
<hr>
<a href="/ticket/add">Add new</a><br><br>
<table>
	<tr><th>Broj tiketa</th><th>Vreme</th><th>Pumpa</th><th>Naslov tiketa</th><th>Korisnik</th><th>Beleske</th><th>Status</th></tr>
	<c:forEach items="${tickets}" var="ticket">
		<tr>
			<td>${ticket.number}</td>						
			<td>${ticket.date_time}</td>
			<td>${ticket.client.name}</td>
			<td>${ticket.title}</td>	
			<td>${ticket.user.username}</td>
			<td>${ticket.noteCount}</td>		
			<td>
				<a href="/ticket/details?id=${ticket.id}">
					<c:choose>
						<c:when test="${ticket.close_date_time != null}"><span style="color: green">CLOSE</span></c:when>
						<c:otherwise><span  style="color: red">OPEN</span></c:otherwise>				
					</c:choose>	
				</a>			
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>