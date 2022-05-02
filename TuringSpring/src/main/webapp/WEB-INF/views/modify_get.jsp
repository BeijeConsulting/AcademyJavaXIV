<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Contatto</title>
</head>
<body bgcolor="#0F0F0F">
<font color=#FFFFFF>
<div align="center">
<c:if test="${empty contatti}">NESSUN CONTATTO</c:if>

<c:forEach items="${contatti}" var="contatto">
${contatto.toString()}<br/>
</c:forEach>
	<br>
	<%="Inserire id contatto da modificare e nuovi valori:"%>
	<br>
	<form action="./modify" method="post">
		<label for="id">id:</label><br> 
			<input type="text" id="id" name="id"><br>
		<label for="name">First name:</label><br>
			<input type="text" id="name" name="name"><br> 
		<label	for="lname">Last name:</label><br> 
			<input type="text" id="lname" name="lname"><br> 
		<label for="tel">Telephone Number:</label><br> 
			<input type="text" id="tel" name="tel"><br>
		<label for="email">Email:</label><br> 
			<input type="text" id="email" name="email"><br> 
		<label for="note">Note:</label><br>
			<input type="text" id="note" name="note"><br> 
		<input type="submit" value="Submit"><br>
	</form>
</div>
</font>


</body>
</html>