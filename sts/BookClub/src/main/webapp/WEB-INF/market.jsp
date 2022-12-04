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
</head>
<body>
<h3>Hello, ${user.userName} Welcome to..</h3>
<h1>The Book Broker</h1> 

<table border="1">
<tr>
<td>Id</td>
<td>Title</td>
<td>Authers Name</td>
<td>Owners</td>
<td>Actions</td>

</tr>
<c:forEach var="book" items="${allbook}">
<c:choose>
    <c:when test="${book.parow==false }">
<tr>
	<td>${book.id}</td>
	<td><a href="/show/${ book.id}">${book.title}</a></td>
	<td>${book.authorname}</td>
	<td>${book.user.userName}</td>
	
	<td><a href="/borrow/${book.id}" >Barrow</a></td>
</tr>
 </c:when> 
</c:choose>
</c:forEach>
</table>
<h1>Books I'am Borrowing..</h1> 
<table border="1">
<tr>
<td>Id</td>
<td>Title</td>
<td>Authers Name</td>
<td>Owners</td>
<td>Actions</td>

</tr>


<c:forEach var="book" items="${allbook}">
<c:choose>
    <c:when test="${book.parow==true && user.id == book.userprow.id}">
<tr>
	<td>${book.id}</td>
	<td><a href="/show/${ book.id}">${book.title}</a></td>
	<td>${book.authorname}</td>
	<td>${book.user.userName}</td>
	
	<td><a href="/return/${book.id}" >return</a></td>
</tr>
 </c:when> 
</c:choose>
</c:forEach>

</table>
<a href="/home">Home</a>
</body>
</html>