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
<meta charset="ISO-8859-1">
<title>Insert team name here</title>
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
</head>
<body>
<h1>Change your Entry </h1>
<a href="/home" >back to the shelves</a>


<form:form action="/edit/${book.id}" method="put" modelAttribute="updatebook">
			<form:input type="hidden" path="user"  value="${user_id}"/>
		<input type="hidden" name="_method" value="put">
		<table>
			<tr>
				<td>
					<form:label path="title">team name</form:label>
					<form:input path="title" class="form-control"/>
					<form:errors path="title" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="authorname">game day</form:label>
					<form:input class="authorname" path="authorname"/>
					<form:errors path="authorname" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label  path="level">level</form:label>
					<form:input class="form-control" path="level"/>
					<form:errors path="level" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" class="form-control" value="Update">
				</td>
			</tr>
		
		</table>

</form:form>
</body>
</html>