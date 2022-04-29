<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.RubricaManager"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo Contatto</title>
</head>
<body bgcolor="#0F0F0F">
<font color=#FFFFFF>
<div align="center">

	<h1>Aggiungi Contatto</h1>
	<br>
	<%="session: " + session.getId()%>
	<br>
	<jsp:useBean id="contatto" class="it.beije.turing.web.rubrica.Contatto" scope="session"></jsp:useBean>
	<%="Contatto aggiunto: "+ contatto.toString() %><br>
	<% session.removeAttribute("contatto"); %>
	<form action="./index.html" method="post">
 		<label for="merge">Torna alla Home:     </label>
  		<input type="submit" id="merge" name="type" value="Submit"><br>
  	</form>
</div>
</font>
	<%-- 
	<%
	for (Contatto c : ris) {
	%>
	<%=c.toString()%><br>
	<%
	}
	%>
	<br>
	--%>
</body>
</html>