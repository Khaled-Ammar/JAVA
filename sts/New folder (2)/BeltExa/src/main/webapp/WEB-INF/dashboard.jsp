<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/style2.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
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
width: 800px;
text-align: center;
}
</style>
</head>
<body>
	
	<div class="flex1">
		<h3>Welcome, ${user.userName}</h3>
		<p><a href="/logout">logout</a></p>
	</div>
	<div class="flex2">
			<p>Show All Trips</p>
			
			
	</div>

	<table class="tb1">

    <thead>
        <tr>
            
            
            <!-- <th>Players</th> -->
            <th>titel</th>
            <th>creator</th>
            <!-- <th>participa</th> -->
            <th>participa</th>
           <th>Actions / Status</th>
           
        </tr>
    </thead>
   <tbody>
  
    
        <c:forEach var="trip" items="${trips}">
    	<tr>
        <td><a href="/show/trip/${trip.id }"><c:out value="${trip.titel}"></c:out></a> </td>
        <td><c:out value="${trip.user.userName}"></c:out> </td>
        <%-- <td><c:out value="${trip.skillLevel}"></c:out></td> --%>
       
         <c:choose>
        <c:when test="${trip.getUsers().size() < trip.getCapacity() }">
          <td><c:out value="${trip.getUsers().size()}"></c:out> / ${trip.getCapacity()}</td>
           </c:when>
         	<c:otherwise>
          <td><c:out value="${trip.getUsers().size()}"></c:out> / ${trip.getCapacity()}</td>
  		</c:otherwise>
  		  
         </c:choose>
         
          <td>
         <c:choose>
         <c:when test="${trip.user.id==user_id}">
       
     			<a href="edit/trip/${trip.id }">edit</a> || <a href="delete/trip/${trip.id}">Delete</a>
     			
		     	
		        <br />
		    </c:when> 
          <c:when test="${user.getTrips().contains(trip)}">
	            	Joining ||	<a href="/leavetrip/${trip.id}">Remove</a>
	         	</c:when> 
		    <c:when test="${trip.getUsers().size() <  trip.getCapacity()}">
		    
        				<a href="/join/trip/${trip.id}">Join</a>
        				
        <br />
   		 </c:when> 
   		 <c:otherwise>
          <td>Full </td>
  		</c:otherwise>
  		   
         </c:choose>
         </td>
         
        
      <%-- 	<td><fmt:formatDate pattern="EEEE" value="${trip.gameDay}" /></td> --%>
        
        
    	</c:forEach>
    
    </tbody>
	</table>
	<br>
	<button style="width:100%;"><a href="/trip">add new trip</a> </button>
	<br>
	<hr>
	
	<br>
	
	
	
</body>
</html>