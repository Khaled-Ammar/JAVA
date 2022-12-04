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
</head>
<body>
<h1>Edit team</h1>
	<a href="/dashboard">dashboard</a>
	<h2>${team.teamName }</h2>
  <br>
	<form:form action="/edit/team/${team.id}" method="post" modelAttribute="team">
			<form:input type="hidden" path="user" value="${user.id }"/>
				<input type="hidden" name="_method" value="put">	
	<table>
			<tr>
				<td>
					<form:label path="teamName">teamName</form:label>
					<form:input path="teamName" class="form-control"/>
					<form:errors path="teamName" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="skillLevel">skillLevel</form:label>
					<form:input  class="form-control" path="skillLevel"/>
					<form:errors path="skillLevel" class="red"/>
					
				</td>
			</tr>
		    
				<tr>
				<td>
					<form:label  path="gameDay">location</form:label>
					<form:input  class="form-control" path="gameDay"/>
					<form:errors path="gameDay" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" class="form-control" value="Send">
				</td>
			</tr>
		
		</table>

</form:form>
<br>
<br>
 <c:choose>
    		<c:when test="${team.user.id==user_id}">
     		
     			<a href="/delete/team/${team.id}">Delete</a>
		        <br />
		    </c:when> 
			     
		</c:choose>
</body>
</html>