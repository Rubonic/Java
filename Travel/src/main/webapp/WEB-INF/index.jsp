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
	<h1>Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="travel" items="${travels}">
				<tr>
					<td><a href="/expenses/show/${travel.id}">${travel.expense}</a></td>
					<td>${travel.vendor}</td>
					<td>${travel.amount}</td>
					<td>
						<a href="/expenses/edit/${travel.id}">Edit</a>
						<form class="flex gap2" action="/expenses/delete/${travel.id}" method="POST">
							<input class="btn_delete" type="submit" value="Delete" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
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
		<br>
		<input class="btn_submit" type="submit" value="Submit" />
	</form:form>
</body>
</html>