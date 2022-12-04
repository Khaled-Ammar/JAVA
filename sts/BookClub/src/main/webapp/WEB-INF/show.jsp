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
</head>
<body>
<h1>Welcome</h1>
<h2>${book.title}</h2>
<a href="/home" >back to the shelves</a>
<h3>${book.user.userName } Read ${book.title} by ${user.userName}</h3>
<h3>Here is ${book.user.userName }'s thoughts:</h3>
<br>
<hr>
<br>

<p> ${book.mythouths} </p>
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
       <h6>I hope you like this book</h6>
        <br />
    </c:otherwise>
</c:choose>


</body>
</html>