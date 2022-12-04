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
<title>Show Team</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/style2.css"/>	
</head>
<body>
	
	<h2>${team.teamName } Details</h2>
	<br>
	<a href="/dashboard">Dashboard</a>
	<br>
	<br>
	

	
		<div>
		<p>Team Name: ${team.teamName }</p>
		<p>Skill Level: ${team.skillLevel }</p>
		<p>Game Day: ${team.gameDay }</p>
		</div>
		
	<hr>
	
	<p>Players</p>
	
	<ul style="margin-left: 10px;">
	 <c:forEach var="team1" items="${team.getUsers()}">
    	
        <li class="li1"><c:out value="${team1.userName}"></c:out></li>
		
	 </c:forEach> 
	 </ul>
	  <br>
	 <p>${error }</p>
	
	<form action="/teamadd/${team.id }" method="post" >
			
		<h2>Add Players</h2>
		<table>
		     <tr>
		     			<label id="userid">Player Name</label>
                    <select name="userid" id="userid" class="form-control">
						<c:forEach var="user" items="${usersnot }">
								<option value="${user.id }">${user.userName }</option>
						</c:forEach>
						</select>
                    
                </tr>
				
			<tr>
				<td>
					<input type="submit" class="form-control" value="Add">
				</td>
			</tr>
		
		</table>
		

</form>
	
	 <c:choose>
    		<c:when test="${team.user.id==user_id}">
     			<a href="/edit/team/${team.id }">edit</a> <br>
     			<a href="/delete/team/${team.id}">Delete</a>
		        <br />
		    </c:when> 
			     
		</c:choose>
</body>
</html>