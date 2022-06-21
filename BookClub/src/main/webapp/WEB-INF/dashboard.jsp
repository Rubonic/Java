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
<title>Books</title>
</head>
<body>
	<div class="container pt-4">
		<div class="d-flex justify-content-between">
			<h2>Welcome ${userName}!</h2>
			<a href="/logout">logout</a>
		</div>
		<div class="d-flex justify-content-between">
			<p>Books from everyone's shelves:</p>
			<a href="/books/add">+ add a book</a>
		</div>
		<div class="container border">
			<div class="row border-bottom fw-bold mb-3">
				<div class="col">ID</div>
				<div class="col">Title</div>
				<div class="col">Author Name</div>
				<div class="col">Posted By</div>
			</div>
			<c:forEach var="book" items="${books}">
				<div class="row border-bottom mb-3">
					<div class="col">${book.id}</div>
					<div class="col"><a href="/books/${book.id}">${book.title}</a></div>
					<div class="col">${book.author}</div>
					<div class="col">${book.creator.userName}</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>