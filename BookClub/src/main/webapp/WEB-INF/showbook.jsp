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
<title>Show a Book</title>
</head>
<body>
	<div class="container pt-4">
		<div class="d-flex justify-content-between">
			<h2 class="fst-italic mb-4">${book.title}</h2>
			<a href="/books">back to the shelves</a>
		</div>
		<div>
			<h4><span class="text-danger">${book.creator.userName} </span>read <span class="text-primary">${book.title}</span> by <span class="text-success">${book.author}</span>.</h4>
			<h4 class="mb-4">Here are ${book.creator.userName}'s thoughts:</h4>
		</div>
		<div class="container">
			<p class="border-top border-bottom border-dark">${book.thoughts}</p>
		</div>
		<c:choose>
			<c:when test="${book.creator.id == userId}">
				<div class="d-flex justify-content-between">
					<div><a href="/books/${book.id}/edit" class="btn btn-primary mb-3">Edit</a></div>
					<div>
						<form action="/books/${book.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<input type="submit" value="Delete" class="btn btn-danger" />
						</form>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div></div>
				<div></div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>