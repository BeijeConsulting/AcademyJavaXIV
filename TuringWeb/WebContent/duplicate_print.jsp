<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.RubricaManager"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stampa e Unisci Duplicati</title>
</head>
<body bgcolor="#0F0F0F">
<font color=#FFFFFF>
<div align="center">
	<h1>Stampa contatti duplicati e uniscili</h1>
	<br>
	<%="session: " + session.getId()%>
	<br>
	<jsp:useBean id="allContatti" type="java.util.List<it.beije.turing.web.rubrica.Contatto>" scope="session"></jsp:useBean>
	<jsp:useBean id="contattiDuplicati" type="java.util.List<it.beije.turing.web.rubrica.Contatto>" scope="session"></jsp:useBean>
	<%
	%>
	<%="Contatti duplicati:"%>
	<br>
	<%
	for (Contatto c : contattiDuplicati) {
	%>
	<%=c.toString()%><br>
	<%
	}
	%>
	<%="Nuova lista contatti:"%>
	<br>
	<%
	for (Contatto c : allContatti) {
	%>
	<%=c.toString()%><br>
	<%
	}
	session.removeAttribute("allContatti");
	session.removeAttribute("contattiDuplicati");
	%>
	<br>
	
	<form action="./index.html" method="post">
 		<label for="merge">Torna alla Home:     </label>
  		<input type="submit" id="merge" name="type" value="Submit"><br>
  	</form>
</div>
</font>
</body>
</html>