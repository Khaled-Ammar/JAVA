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
</head>
<body>
	
	<div class="flex1">
		<h3>Welcome, ${user.userName}</h3>
		<p><a href="/logout">logout</a></p>
	</div>
	<div class="flex2">
			<p>Show All Teams</p>
			
			
	</div>

	<table class="tb1">

    <thead>
        <tr>
            <th>Team Name</th>
            <th>Skill Level (1-5)</th>
            <th>Players</th>
            <th>Game Day</th>
           
        </tr>
    </thead>
   <tbody>
  
    
        <c:forEach var="team" items="${teams}">
    	<tr>
        <td><a href="/show/team/${team.id }"><c:out value="${team.teamName}"></c:out></a> </td>
        <td><c:out value="${team.skillLevel}"></c:out></td>
       
         <c:choose>
        <c:when test="${team.getUsers().size() < 9}">
          <td><c:out value="${team.getUsers().size()}"></c:out> / 9</td>
           </c:when>
         	<c:otherwise>
          <td><c:out value="${team.getUsers().size()}"></c:out> / 9</td>
  		</c:otherwise>
  		  
         </c:choose>
        
        
      	<td><fmt:formatDate pattern="EEEE" value="${team.gameDay}" /></td>
        
        
    	</c:forEach>
    
    </tbody>
	</table>
	<br>
	<button style="width:100%;"><a href="/team">Create New Team</a> </button>
	<br>
	<hr>
	
	<br>
	
	
	
</body>
</html>