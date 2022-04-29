<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.RubricaManager"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rimuovi Contatto</title>
</head>
<body bgcolor="#0F0F0F">
<font color=#FFFFFF>
<div align="center">
	<%
	RubricaManager rm = new RubricaManager();
	%>
	<h1>Elimina Contatto</h1>
	<br>
	<%="session: " + session.getId()%>
	<br>
	<%
	for (Contatto c : rm.getAllContatti()) {
	%>
	<%=c.toString()%><br>
	<%
	}
	%>
	<br>
	<%="Inserire id contatto da eliminare:"%>
	<br>
	<form action="./remove_servlet" method="post">
		<label for="id">id:</label><br>
 		<input type="text" id="id" name="id"><br>
 		<input type="submit" value="Submit"><br>
	</form>
	
	<%
	
	%>
	
</div>
</font>
</body>
</html>