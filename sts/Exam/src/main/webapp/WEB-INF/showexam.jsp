<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Show exam</title>
</head>
<body>

<c:choose>
    <c:when test="${allexam.user.id==user_id}">
        <h2>${allexam.title }</h2>
        ${allexam.user.userName } read ${allexam.title } by ${allexam.author }
        <hr>
         ${allexam.myThoughts }
       
        <hr>
        <a href="/edit/getexam/${allexam.id }">Edit</a>
         <form action="/delete/${allexam.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
    	</form>
        <h2></h2>
        <br />
    </c:when>    
    <c:otherwise>
       <h2>this exam not for you</h2>
        <br />
    </c:otherwise>
</c:choose>


</body>
</html>