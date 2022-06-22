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
	<table>
		<form:form action="save" modelAttribute="client">
			<form:hidden path="id" />
			<tr>
				<td><form:label path="code" /></td>
				<td><form:input path="code" /></td>
				<td><form:errors path="code" cssStyle="color: red"/></td>
			</tr>
			<tr>
				<td><form:label path="name" /></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssStyle="color: red"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</form:form>
	</table>
</body>
</html>