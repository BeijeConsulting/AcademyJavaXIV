<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.RubricaManager"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	
	RubricaManager rm = new RubricaManager();
	%>
	<%="Modifica contatto"%>
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
	<%="Inserire id contatto da modificare e nuovi valori:"%>
	<br>
	<form action="./modify_servlet" method="post">
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



</body>
</html>