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
<title>Show Name</title>
</head>
<body>
	<div class="container pt-4">
		<div class="d-flex justify-content-between">
			<h2 class="fst-italic mb-4">${namejoy.name}</h2>
			<a href="/names">Dashboard</a>
			<a href="/names/${namejoy.id}/edit" class="btn btn-primary mb-3">Edit</a>
		</div>
		<div>
			<h4><span class="text-danger"></span>added by<span class="text-primary">${namejoy.creator.userName}</span></h4>
			<div>
				<h4></h4><span class="text-success">Gender:${namejoy.gender}</span></h4>
			<div>
				<h4><span class="text-success">Origin:${namejoy.origin}</span><h4>

		</div>
		<div class="container">
			<p class="border-top border-bottom border-dark">Meaning:${namejoy.meaning}</p>
		</div>
		<c:choose>
			<c:when test="${namejoy.name == user.id}">
				<div class="d-flex justify-content-between">
					<div><a href="/names/${namejoy.id}/edit" class="btn btn-primary mb-3">Edit</a></div>
					<div><a href="/names/${namejoy.id}/delete" class="btn btn-danger mb-3">Delete</a></div>
					<div>
						<form action="/names/${namejoy.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<input type="submit" value="Delete" class="btn btn-danger" />
						</form>
					</div>
					<div>
						<form action="/names/${namejoy.id}/edit" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<input type="submit" value="Edit" class="btn btn-danger" />
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