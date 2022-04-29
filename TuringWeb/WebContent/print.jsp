<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.RubricaManager"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stampa Contatti</title>
</head>
<body bgcolor="#0F0F0F">
<font color=#FFFFFF>
<div align="center">
	<jsp:useBean id="allContatti" type="java.util.List<it.beije.turing.web.rubrica.Contatto>" scope="session"></jsp:useBean>
	<h1>Contatti in rubrica:</h1>
	<%
	for (Contatto c : allContatti) {
	%>
	<%=c.toString()%><br>
	<%
	}
	session.removeAttribute("allContatti");
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