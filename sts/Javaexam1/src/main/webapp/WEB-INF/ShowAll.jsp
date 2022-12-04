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
<style >
table{
border: 2px solid black ; 
width: 600px;
text-align: center;
}
</style>
</head>
<body>
<h1>All teams </h1>
<h1>Welcome ${user.userName }</h1>

<p> <a href="/logout" >LogOut</a></p>

<br>
<br>
<br>
<br>
<table border="1">
<tr>
<td>Id</td>
<td>team name</td>
<td>level </td>
<td>game day </td>
<td>Player name</td>

</tr>
<c:forEach var="book" items="${allbook}">
<tr>
	<td>${book.id}</td>
	<td><a href="/show/${ book.id}">${book.title}</a></td>
	<td>${book.level}</td>
	<td>${book.authorname}</td>
	<td>${book.user.userName}</td>
</tr>
</c:forEach>


</table>
<br>
<a href="/book" >Add team  </a>
<br>
<br>

<a href="/market">team your goin</a>
</body>
</html>