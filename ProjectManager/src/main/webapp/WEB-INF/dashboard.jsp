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
	<h1> Hello, ${user.firstName }</h1>
	<a href="/logout"> Logout</a>
   	<table class="table">
   	<thead>
   		<tr>
   			<th> ID </th>
   			<th> Project Title </th>
   			<th> Team Lead </th>
   			<th> Due Date </th>
   			<th> Actions</th>
   		</tr>
   	</thead>
   	<tbody>
   		<c:forEach var="project" items="${projects }">
   		<tr>
   			<td>${project.id }</td>
   			<td>
   			<a href="/projects/${project.id }"><c:out value="${project.title }"></c:out></a>
   			
   			 </td>
   			<td> ${project.teamlead.firstName } </td>
   			<td> 
   			<fmt:formatDate value="${project.duedate }" pattern="MMM dd"/>
   			</td>
   			<td> <a href="/projects/${project.id }/edit"> Edit</a> </td>
   		</tr>
   		</c:forEach> 
   	</tbody>
   	</table>
   	<a href="/projects/new"> Add a new project</a>
   	
   	
   </div>
</body>
</html>