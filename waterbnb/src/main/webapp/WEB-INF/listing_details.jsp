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

<p><a href="/">Home</a></p>
<p><a href="/logout">Log Out</a></p>

<table>
    <tbody>
		<tr>
			<td class="float-left">${listing.location}</td>
			<td class="float-left">Email: ${listing.host.email}</td>
		</tr>
		<tr>
			<td rowspan=3 class="float-left">${listing.description}</td>
			<td class="float-left">Name: ${listing.host.firstName} ${listing.host.lastName}</td>
		</tr>
		<tr>
			<td class="float-left">Pool Size: ${listing.size}</td>
		</tr>
		<tr>
			<td class="float-left">Cost: $${listing.price}</td>
		</tr>	
		<tr>
			<td class="float-left">Rating: ${listing.rating}/5</td>
			<c:if test = "${user==null}">
			   <td class="float-right">Sign in to leave a review</td>
			</c:if>
			<c:if test = "${user!=null}">
			   <td class="float-right"><a href="/pools/${listing.id}/review">Leave a review</a></td>
			</c:if>
		</tr>	
    </tbody>
</table>

<iframe src="/reviews/${listing.id}" title="Reviews Iframe"></iframe>

</body>
</html>