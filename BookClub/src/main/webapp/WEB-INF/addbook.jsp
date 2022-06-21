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
<title>Add a Book</title>
</head>
<body>
	<div class="container pt-4">
		<div class="d-flex justify-content-between">
			<h2>Add a Book to Your Shelf!</h2>
			<a href="/books">back to the shelves</a>
		</div>
		<div class="container">
			<form:form action="/books/add" method="post" modelAttribute="book" class="form">
				<form:label path="title" class="form-label">Title</form:label>
				<form:errors path="title" class="text-danger"></form:errors>
				<form:input path="title" type="text" class="form-control"/>
				
				<form:label path="author" class="form-label">Author</form:label>
				<form:errors path="author" class="text-danger"></form:errors>
				<form:input path="author" type="text" class="form-control"/>
				
				<form:label path="thoughts" class="form-label">Thoughts</form:label>
				<form:errors path="thoughts" class="text-danger"></form:errors>
				<form:textarea path="thoughts" type="text" class="form-control"></form:textarea>
				
				<form:hidden path="creator" value="${userId}"/>
				
				<button class="btn btn-primary mt-3">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>