<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css" />
</head>
<body>
	<h1>Ticket</h1>
	<hr>
	<table>
		<form:form action="/ticket/save" modelAttribute="ticket">
			<form:hidden path="id" />
			<tr>
				<td>User</td>
				<td><form:select path="user" items="${users}" itemLabel="username" itemValue="id" cssStyle="width: 100%"/></td>
			</tr>
			<tr>
				<td>Client</td>
				<td>
					<form:select path="client" cssStyle="width: 100%">
						<form:option value="" label="- Select Client -" />
						<form:options items="${clients}" itemLabel="name" itemValue="id" />
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Title</td>
				<td><form:input path="title" cssStyle="width: 100%; padding: 5px; box-sizing: border-box;"/></td>
				<td><form:errors path="title" cssStyle="color: red"/></td>
			</tr>
			<tr>
				<td>Note</td>
				<td><form:textarea path="note" cols="50" rows="10" cssStyle="padding: 10px"/></td>
				<td><form:errors path="note" cssStyle="color: red"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" style="width: 50%; padding: 6px; display: block; margin: auto"/></td>
			</tr>
			
		</form:form>
	</table>
	
</body>
</html>