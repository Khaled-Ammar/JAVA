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
<title>Book Market</title>
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
<h3>Hello, ${user.userName} Welcome to..</h3>
<h1>The team you goin</h1> 

<a href="/home">Home</a>
<br>


 <h3>${book.user.userName } goine in ${book.title} team</h3>
<h3>Here is ${book.user.userName }'s thoughts:</h3> 
<br>
<hr>


<h2>Player name</h2>

<c:forEach var="book" items="${allbook}">
<select>
	 <option value="${user.id}">${book.user.userName}</option>
</select>
</c:forEach>

<br>
<p> the level of the player is : ${book.level} </p>
<br>
<hr>

<c:choose>
    <c:when test="${book.user.id==user_id}">
        <form:form action="/update/${book.id}" method="post" modelAttribute="updatebook">
        					<input type="submit" class="form-control" value="Edit">
        </form:form> 
        <form:form action="/delete/${book.id}" method="post" modelAttribute="updatebook">
        					<input type="submit" class="form-control" value="Delete">
        </form:form> 
        <br />
    </c:when>    
    <c:otherwise>
       <h6>I hope you like this team </h6>
        <br />
    </c:otherwise>
</c:choose>









<h3>the leader can have a team on her </h3>
<table border="1">
<tr>
<td>Id</td>
<!-- <td>team name</td>
<td>level </td> -->
<td>player</td>
<td>Actions</td>

</tr>
<c:forEach var="book" items="${allbook}">
<c:choose>
    <c:when test="${book.parow==false }">
<tr>
	<td>${book.id}</td>
	<%-- <td><a href="/show/${ book.id}">${book.title}</a></td>
	<td>${book.authorname}</td> --%>
	<td>${book.user.userName}</td>
	
	<td><a href="/borrow/${book.id}" >goin </a></td>
</tr>
 </c:when> 
</c:choose>
</c:forEach>
</table>
<h1>team name I'am goin..</h1> 
<h3>the leader can keac a member on her </h3>
<table border="1">
<tr>
<td>Id</td>
<!-- <td>team name</td>
<td>level </td> -->
<td>player</td>
<td>Actions</td>

</tr>


<c:forEach var="book" items="${allbook}">
<c:choose>
    <c:when test="${book.parow==true && user.id == book.userprow.id}">
<tr>
	<td>${book.id}</td>
	<%-- <td><a href="/show/${ book.id}">${book.title}</a></td>
	<td>${book.authorname}</td> --%>
	<td>${book.user.userName}</td>
	
	<td><a href="/return/${book.id}" >out</a></td>
</tr>
 </c:when> 
</c:choose>
</c:forEach>







</body>
</html>