<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Demo JSP</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>

</head>
<body>
<h3>Send an Omikuji</h3>
<form action='/handle' method='post'>
    <label>Pick any number from 5 to 25</label>
    <input type="number" name="number" max="25" min="5">
    <label>Enter the name of a city:</label>
    <input type="text" name='city'>
    <label>Enter the name of any real person:</label>
    <input type='text' name='realPerson'>
    <label>Enter professional endeavor or hobby:</label>
    <input type="text" name="endeavor">
    <label>Enter any type of living thing: </label>
    <input type="text" name="livingThing">
    <label>Say something nice to someone:</label>
    <textarea name="smthNice" cols="40" rows="5"></textarea>
    <h5>Send and show a friend</h5>
    <input type='submit' value='Send'>
</form>
</body>
</html>