<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/style2.css">
<title>Login And Registration</title>
</head>
<body>

<h3>Welcome, ${newUser.userName}</h3>
<p>Show All exams</p>
<p><a href="/logout">logout</a></p>
<p><a href="/exam">Add exam</a></p>


<table class="tb1">

    <thead>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>author</th>
            <th>Owner</th>
            <th>Actions</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach var="exam" items="${examnoborrow}">
    	<tr>
    	<%-- <c:choose>
    	<c:when test="${exam.borrow.id!=user_id || exam.user.id==user_id }"> --%>
        <td><c:out value="${exam.id}"></c:out></td>
        <td><a href="/getexam/${exam.id }"><c:out value="${exam.title}"></c:out></a> </td>
        <td><c:out value="${exam.author}"></c:out></td>
        <td><c:out value="${exam.user.userName}"></c:out></td>
   
<%--     </c:when>    
 
</c:choose>
        --%>
        
        <td>
        <c:choose>
    <c:when test="${exam.user.id==user_id}">
       
     <a href="edit/getexam/${exam.id }">edit</a><form action="/delete/${exam.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
    	</form>
     	
        <br />
    </c:when>    
    <c:otherwise>
        
    
       <a href="/addborrow/${exam.id}">borrow</a> 
        <br />
    </c:otherwise>
</c:choose>
        </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
















<table class="tb1">

    <thead>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>author</th>
            <th>Owner</th>
            <th>Actions</th>
        </tr>
    </thead>
   <tbody>
        <c:forEach var="exam" items="${bk}">
    	<tr>

        <td><c:out value="${exam.id}"></c:out></td>
        <td><a href="/getexam/${exam.id }"><c:out value="${exam.title}"></c:out></a> </td>
        <td><c:out value="${exam.author}"></c:out></td>
        <td><c:out value="${exam.user.userName}"></c:out></td>
   

       
        
        <td>
        <c:choose>
    <c:when test="${exam.user.id==user_id}">
       
     <a href="edit/getexam/${exam.id }">edit</a> || <a href="delete/${exam.id }">delete</a>
     	
        <br />
    </c:when>    
    <c:otherwise>
       <a href="Removeborrow/${exam.id }">return</a> 
        <br />
    </c:otherwise>
</c:choose>
        </td>
        </tr>
    </c:forEach>
    </tbody>
</table>









</body>
</html>