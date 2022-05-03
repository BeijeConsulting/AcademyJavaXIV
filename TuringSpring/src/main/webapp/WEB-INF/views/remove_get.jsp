<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina Contatto</title>
</head>
<body bgcolor="#0F0F0F">
<font color=#FFFFFF>
<div align="center">
<c:if test="${empty contatti}">NESSUN CONTATTO</c:if>

<c:forEach items="${contatti}" var="contatto">
${contatto.toString()}<br/>
</c:forEach>
	<br>
	<%="Inserire id contatto da eliminare:"%>
	<br>
	<form action="./remove" method="post">
		<label for="id">id:</label><br> 
			<input type="text" id="id" name="id"><br>
		<input type="submit" value="Submit"><br>
	</form>
</div>
</font>


</body>
</html>