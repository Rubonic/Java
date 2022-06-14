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
<body class="grid p1 bg_white2">
	<h1 class="text_center">Send an Omikuji</h1>
	<br>
	<form class="grid gap1 text_center" action="/submit" method="POST">
		<div>
			<h4>Pick any number from 5 to 25<h4>
			<input type="name" name="number" placeholder="Number"/>
		</div>
		<div>
			<h4>Enter the name of any city<h4>
			<input type="name" name="city" placeholder="City" />
		</div>
		<div>
			<h4>Enter the name of any real person<h4>
			<input type="name" name="name" placeholder="Name" />
		</div>
		<div>
			<h4>Enter professional endeavor or hobby:<h4>
			<input type="name" name="hobby" placeholder="Hobby" />
		</div>
		<div>
			<h4>Enter any type of living thing<h4>
			<input type="name" name="thing" placeholder="Thing" />
		</div>
		<div>
			<h4>Say something nice to someone:<h4>
			<input type="name" name="nice" placeholder="Nice" />
		</div>
		<input class="btn_submit" type="Submit" value="Send" />
	</form>
</body>
</html>