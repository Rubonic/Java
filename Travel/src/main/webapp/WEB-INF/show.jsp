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
	<h1>Expense Details</h1>
	<br>
	<p>Expense: ${travel.expense}</p>
	<p>Vendor: ${travel.vendor}</p>
	<p>Amount: ${travel.amount}</p>
	<p>Description: ${travel.description}</p>

	<a href="/expenses">Go Back</a>
	<a href="/expenses/edit/${travel.id}">Edit</a>
</body>
</html>