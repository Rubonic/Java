<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Water BnB</title>
</head>
<body>

<p>Find places to swim and sleep on water bnb!</p>
<p><a href="/account">Sign Up/Sign In</a></p>
<c:if test = "${user!=null}">
   <p><a href="/logout">Log Out</a></p>
   <br>
   <p>Find your pool!</p>
</c:if>
<c:if test = "${user==null}">
   <p>Find places to swim and sleep on water bnb!</p>
</c:if>

<form action="/" method="post">
	<table>
	    <tbody>
			<tr>
				<td><input type = "text" name = "locationSearch"  class="input"></td>
				<td><input class="input" class="button" type="submit" value="Search"/></td>
			</tr>
	    </tbody>
	</table>
</form>

<c:if test = "${searchResults!=null}">
   <table>
    <thead> 
    	<tr>
    		<th>Address</th>
    		<th>Pool Size</th>
    		<th>Cost per Night</th>
    		<th>Details</th>
    	</tr>
    </thead>
    <tbody>
    	<c:forEach var="listing" items="${searchResults}">
		<tr>
			<td>${listing.location}</td>
			<td>${listing.size}	</td>
			<td>$${listing.price}</td>
			<td>Rating: ${listing.rating}/5 <a href="/pools/${listing.id}">See More</a></td>
		</tr>	
		</c:forEach>
    </tbody>
	</table>
</c:if>

</body>
</html>