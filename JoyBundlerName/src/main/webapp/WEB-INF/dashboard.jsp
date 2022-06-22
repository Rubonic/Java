<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Names</title>
</head>
<body>
	<div class="container pt-4">
		<div class="d-flex justify-content-between">
			<h2>Welcome ${userName}!</h2>
			<a href="/logout">logout</a>
		</div>
		<div class="d-flex justify-content-between">
			<p>Here are some suggestions:</p>
			<a href="/names/add">New Name</a>
		</div>
		<div class="container border">
			<div class="row border-bottom fw-bold mb-3">
				<div class="col">ID</div>
				<div class="col">Name</div>
				<div class="col">Gender</div>
				<div class="col">Origin</div>
			</div>
			<c:forEach var="name" items="${names}">
				<div class="row border-bottom mb-3">
					<div class="col">${name.id}</div>
					<div class="col"><a href="/names/${name.id}">${name.name}</a></div>
					<div class="col">${name.gender}</div>
					<div class="col">${name.origin}</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>