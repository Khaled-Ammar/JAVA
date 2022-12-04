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
<title>Insert title here</title>
<style >
table{
border: 2px solid black ; 
width: 600px;
text-align: center;
}
</style>
</head>
<body>
<h1>All Books</h1>
<h1>Welcome ${user.userName }</h1>

<p> <a href="/logout" >LogOut</a></p>
<a href="/book" >Add Book </a>
<br>
<br>
<br>
<br>
<table border="1">
<tr>
<td>Id</td>
<td>Titel</td>
<td>Auther Name</td>
<td>Posted By</td>

</tr>
<c:forEach var="book" items="${allbook}">
<tr>
	<td>${book.id}</td>
	<td><a href="/show/${ book.id}">${book.title}</a></td>
	<td>${book.authorname}</td>
	<td>${book.user.userName}</td>
</tr>
</c:forEach>


</table>
<br>
<br>
<br>
<a href="/market">Book Market</a>
</body>
</html>