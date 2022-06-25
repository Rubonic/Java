<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Current Listings</title>
</head>
<body>

<c:forEach var="review" items="${reviews}">
	<p>
		${review.user.firstName}:
		<br>
		Rating: ${review.rating}/5
	</p>
	<p>${review.text}</p>
	<hr>
</c:forEach>

</body>
</html>