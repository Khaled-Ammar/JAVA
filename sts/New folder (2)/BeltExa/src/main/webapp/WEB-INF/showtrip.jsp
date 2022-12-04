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
<meta charset="windows-1256">
<title>Show trip</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/style2.css"/>	
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
<style >
table{
border: 2px solid black ; 
width: 600px;
text-align: center;
}
</style>
</head>
<body>
	
	<h2>${trip.creatName } Details</h2>
	<br>
	<a href="/dashboard">Dashboard</a>
	<br>
	<br>
	

	
		<div>
		
		<p>creator: ${trip.user.userName }</p>
		<p>participa: ${trip.getCapacity() }</p>
		<p>titel: ${trip.titel }</p>
		<p>Description: ${trip.getDescription()}</p>
		<%-- <p>Game Day: ${trip.gameDay }</p> --%>
		</div>
		
	<hr>
	
	<p>creators Name</p>
	
	<ul style="margin-left: 10px;">
	 <c:forEach var="trip1" items="${trip.getUsers()}">
    	
        <li class="li1">${trip1.userName}  <c:forEach var="i" items="${usertrip}"><c:choose><c:when test="${ trip1.id==i.user.id} <%-- ${usertrips.getCreatedAt} --%>" >${i.getCreatedAt()  }</c:when></c:choose></c:forEach> <a href="/leavetrip/${trip.id}">Remove</a></li>

</c:forEach> 
	 </ul>
	  <br>
	 <p>${error }</p>
	
	<%-- <form action="/tripadd/${trip.id }" method="post" >
			
		<h2>Trips creator Name</h2>
	
		

</form>
	<table class="table" style="width:30%;">

    <thead>
        <tr>
            <th>Name</th>
            
         
        </tr>
    </thead>
   <tbody>
      	 <c:forEach var="trips" items="${trip.getUsers()}">
    	<tr>
        <td><c:out value="${trips.userName}"></c:out></td>
        </tr>
		</c:forEach>
       
    
    </tbody>
	</table> --%>
	 <c:choose>
    		<c:when test="${trip.user.id==user_id}">
     			<a href="/edit/trip/${trip.id }">edit</a> <br>
     			<a href="/delete/trip/${trip.id}">Delete</a>
		        <br />
		    </c:when> 
			     
		</c:choose>
</body>
</html>







