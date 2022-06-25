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

<h2><a href="/">Home</a></h2>
<h2><a href="/logout">Log Out</a></h2>

<form:form action="/pools/${listing.id}/review" method="post" modelAttribute="review">

	<table>
	    <thead>
	    	<tr>
	            <td colspan=2>Review of ${listing.location}</td>
	        </tr>
	        <tr>
	            <td class="float-left">Listing Description:</td>
	            <td class="float-left">
	            	<form:errors path="text" class="text-danger"/>
					<form:textarea rows="4" class="input" path="text"/>
	            </td>
	        </tr>
	        <tr>
	        	<td>
	        		<form:select path="rating" id="" name="" class="form-select">
		                <c:forEach var="num" items="${nums}">
	                    	<option value="${num}">${num}</option>
	                    </c:forEach>
		            </form:select>
	        	</td>
	        	<td><input class="input" type="submit" value="Submit Review"/></td>
	        </tr>
	    </thead>
	</table>
</form:form>

</body>
</html>