<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Languages Display and Add</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>	
</head>
<body>
	<h1>Create Dojo</h1>
    	<form:form action="/add" method="post" modelAttribute="dojo">
		
		
					<form:label path="name">name</form:label>
					<form:input class="form-control" path="name"/>
					<form:errors path="name" class="red"/>
					<input type="submit" class="form-control" value="Send">
		</form:form>
</body>
</html>