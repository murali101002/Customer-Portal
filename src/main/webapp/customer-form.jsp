<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customers list</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Customer</h3>
		<form:form action="addSuccess" modelAttribute="customer" method="POST">
		<form:hidden path="id"/>
			<table>
				<tr>
					<td><label>First Name</label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td><label>Last Name</label></td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
		<a href="${pageContext.request.contextPath}/customer/list">Back</a>
	</div>

</body>
</html>