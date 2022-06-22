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
<title>Edit Name</title>
</head>
<body>
	<div class="container pt-4">
		<h2>Change Your Entry</h2>
		<a href="/names">Dashboard</a>
	</div>
	<div class="container">
		<form:form action="/names/${namejoy.id}/edit" method="post" modelAttribute="namejoy" class="form">
		<input type="hidden" name="_method" value="put"/>
		
			<form:label path="name" class="form-label">New Name:</form:label>
				<form:errors path="name" class="text-danger"></form:errors>
				<form:input path="name" type="text" class="form-control"/>
				
				<form:label path="gender" class="form-label">Gender</form:label>
				<form:errors path="gender" class="text-danger"></form:errors>
				<form:input path="gender" type="text" class="form-control"/>
				
				<form:label path="origin" class="form-label">Origin</form:label>
				<form:errors path="origin" class="text-danger"></form:errors>
				<form:textarea path="origin" type="text" class="form-control"></form:textarea>
				
				<form:label path="meaning" class="form-label">Meaning</form:label>
				<form:errors path="meaning" class="text-danger"></form:errors>
				<form:textarea path="meaning" type="text" class="form-control"></form:textarea>
			
			<form:hidden path="creator" value="${user.id}"/>
			
			<button class="btn btn-primary mt-3">Submit</button>
	
					
			
			
		</form:form>
		<form action="/names/${namejoy.id}/delete" method="post">
				<input type="hidden" name="_method" value="delete"> 
				<input type="submit" value="Delete" class="btn btn-danger" />
		</form>
						
				
</body>
</html>