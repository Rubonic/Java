<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div class="container mt-5">
	<h1> Project Details</h1>
	<h5> Title: ${project.title }</h5>
	<h5> Description: ${project.description }</h5>
	<h5> DueDate : <fmt:formatDate value="${project.duedate }" pattern="MM-dd-yyyy"/></h5>
   
   	<form action="/projects/${project.id }/delete" method="post">
   		<input type="hidden" name="_method" value="delete" />
   		<button class="btn btn-danger"> Delete</button>
   	</form>
   </div>
</body>
</html>