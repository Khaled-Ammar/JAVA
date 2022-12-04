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
<h1>Change your Entry </h1>
<a href="/home" >back to the shelves</a>


<form:form action="/edit/${book.id}" method="put" modelAttribute="updatebook">
			<form:input type="hidden" path="user"  value="${user_id}"/>
		<input type="hidden" name="_method" value="put">
		<table>
			<tr>
				<td>
					<form:label path="title">title</form:label>
					<form:input path="title" class="form-control"/>
					<form:errors path="title" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="authorname">author</form:label>
					<form:input class="authorname" path="authorname"/>
					<form:errors path="authorname" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label  path="mythouths">mythouths</form:label>
					<form:input class="form-control" path="mythouths"/>
					<form:errors path="mythouths" class="red"/>
					
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