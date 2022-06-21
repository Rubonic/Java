<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Edit Book</h1>
		<form:form action="/books/${book.id}" modelAttribute="book" class="form" method="post">
			<div class = "form-group">
				<form:label path="title">Title:</form:label>
		    	<form:input path="title" class="form-control"/>
		    	<form:errors class ="text-danger" path="title"/>
			</div>
			<div class = "form-group">
				<form:label path="author">Author:</form:label>
		    	<form:input path="author" class="form-control"/>
		    	<form:errors class ="text-danger" path="author"/>
			</div>
				<div class = "form-group">
				<form:label path="thoughts">My Thoughts:</form:label>
		    	<form:input path="thoughts" class="form-control"/>
		    	<form:errors class ="text-danger" path="thoughts"/>
			</div>
			<div class="form-row">
				<form:errors path="user" class="error"/>
				<form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
			</div>
			<br/>
			<button class ="btn-primary">Edit This Book</button>
		</form:form>
	</div>	
</body>
</html>