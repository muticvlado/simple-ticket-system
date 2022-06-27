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
<%@ include file="header.jsp" %>
	<h1>Registration</h1>
	<hr>
	
	<form:form action="save" modelAttribute="user">
		<form:hidden path="id" />
		<p><form:errors path="username" cssClass="error"/></p>	
		<p><form:errors path="password" cssClass="error"/></p>	
		<table>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password"/></td>
			</tr>
			<tr>
				<td><form:label path="enabled">Enabled</form:label></td>
				<td><form:checkbox path="enabled"/></td>
			</tr>
			<tr>
				<td><form:label path="role">Role</form:label></td>
				<td>
					<form:select path="role">
						<form:option value="">- Izaberi vrstu korisnika -</form:option>
						<form:option value="ROLE_USER">USER</form:option>
						<form:option value="ROLE_ADMIN">ADMIN</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" style="width: 50%; padding: 6px; display: block; margin: auto"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>