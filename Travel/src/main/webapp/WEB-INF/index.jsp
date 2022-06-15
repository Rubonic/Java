<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<h2>Add an expense:</h2>
	<br>
	<form:form class="grid" action="/expenses" method="POST" modelAttribute="travel">
		<form:label path="expense">Expense:</form:label>
		<form:errors class="col_red" path="expense"></form:errors>
		<form:input placeholder="" path="expense"></form:input>
		<br>
		<form:label path="vendor">Vendor:</form:label>
		<form:errors class="col_red" path="vendor"></form:errors>
		<form:input placeholder="" path="vendor"></form:input>		
		<br>
		<form:label path="amount">Amount:</form:label>
		<form:errors class="col_red" path="amount"></form:errors>
		<form:input placeholder="" type="number" path="amount"></form:input>		
		<br>
		<form:label path="description">Description:</form:label>
		<form:errors class="col_red" path="description"></form:errors>
		<form:input placeholder="" path="description"></form:input>				

		<input class="btn_submit" type="submit" value="Submit" />
	</form:form>
</body>
</html>