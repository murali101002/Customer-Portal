<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--  <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css">-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/styles.css">

<title>View Customers</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customers list</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<form:form action="search" method="POST">
                Search customer: <input type="text" name="theSearchName" />

				<input type="submit" value="Search" class="add-button" />
			</form:form>
			<table id="custTable">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tempCust" items="${customers}">
						<c:url var="updateLink" value="/customer/showFormToUpdate">
							<c:param name="customerId" value="${tempCust.id}"></c:param>
						</c:url>
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${tempCust.id}"></c:param>
						</c:url>
						<tr>
							<td>${tempCust.firstName}</td>
							<td>${tempCust.lastName}</td>
							<td>${tempCust.email}</td>
							<td><a href="${updateLink}">Update</a> | <a
								href="${deleteLink}"
								onclick="if(!(confirm('Are you sure to delete this customer?'))) return false">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormToAdd';return false;"
				class="add-button">
		</div>
	</div>
</body>
</html>