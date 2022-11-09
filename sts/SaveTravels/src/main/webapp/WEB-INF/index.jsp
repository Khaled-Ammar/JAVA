<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="style.css"/>	
</head>
<body>
	
	<h2>Save Travels</h2>
	<table class="tb1">
	
    <thead>
        <tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="tr" items="${tr}">
    	<tr>
        <td><a href="/exp/${tr.id }"> <c:out value="${tr.name}"></c:out></a></td>
        <td><c:out value="${tr.vendor}"></c:out> </td>
        <td>$<c:out value="${tr.amount}"></c:out></td>
        <td><a href="/ex/${tr.id }">Edit</a></td>
        <td> <form action="/delete/${tr.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
		</form>
		</td>
     

        </tr>
    </c:forEach>
    </tbody>
</table>
<br>

	<form:form action="/go" method="post" modelAttribute="travel">
	<h2>Add an expense</h2>
		<table>

		
		
			<tr>
				<td>
					<form:label path="name">Enter Name of expense</form:label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name" class="red"/>
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="vendor">Enter vendor of expense</form:label>
					<form:input class="form-control" path="vendor"/>
					<form:errors path="vendor" class="red"/>
					
				</td>
			</tr>
			<tr>
				<td>
					<form:label  path="amount">Enter amount of expense</form:label>
					<form:input class="form-control" path="amount"/>
					<form:errors path="amount" class="red"/>
					
				</td>
			</tr>
				<tr>
				<td>
					<form:label  path="description">Enter Desc</form:label>
					<form:input  class="form-control" path="description"/>
					<form:errors path="description" class="red"/>
				</td>
			</tr>
				<tr>
				<td>
					<input type="submit" class="form-control" value="Send">
				</td>
			</tr>
		
		</table>

</form:form>
	
</body>
</html>