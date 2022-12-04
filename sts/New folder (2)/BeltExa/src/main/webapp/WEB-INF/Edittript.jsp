<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
   	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/style2.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <style >.container{display: flex; justify-content: space-around;margin-top: 100px}</style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<style >body{margin: 50px;}#sd{margin-left: 90%;}</style>
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/style2.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<style >
table{
border: 2px solid black ; 
width: 600px;
text-align: center;
}
</style>
</head>
<body>
<h1>Edit trip</h1>
	<a href="/dashboard">dashboard</a>
	<h2>${trip.titel}</h2>
  <br>
	<form:form action="/edit/trip/${trip.id}" method="post" modelAttribute="trip">
			<form:input type="hidden" path="user" value="${user.id }"/>
				<input type="hidden" name="_method" value="put">	
	<table>
			
				<tr>
				<td>
					<form:label path="titel">titel</form:label>
					<form:input path="titel" class="form-control"/>
					<form:errors path="titel" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="Capacity">Capacity</form:label>
					<form:input path="Capacity" class="form-control"/>
					<form:errors path="Capacity" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="Description">Description</form:label>
					<form:input path="Description" class="form-control"/>
					<form:errors path="Description" class="red"/>
				</td>
			</tr>
		<%-- 	<tr>
				<td>
					<form:label path="skillLevel">participa</form:label>
					<form:input  class="form-control" path="skillLevel"/>
					<form:errors path="skillLevel" class="red"/>
					
				</td>
			</tr>
		     --%>
		<%-- 		<tr>
				<td>
					<form:label  path="gameDay">location</form:label>
					<form:input  class="form-control" path="gameDay"/>
					<form:errors path="gameDay" class="red"/>
					
				</td>
			</tr> --%>
			<tr>
				<td>
					<input type="submit" class="form-control" value="Edit trips">
				</td>
			</tr>
		
		</table>

</form:form>
<br>
<br>
 <c:choose>
    		<c:when test="${trip.user.id==user_id}">
     		
     			<a href="/delete/trip/${trip.id}">Delete</a>
		        <br />
		    </c:when> 
			     
		</c:choose>
</body>
</html>