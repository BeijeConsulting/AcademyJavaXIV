<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="it.beije.turing.web.rubrica.ServletMostra"%>
<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.JPACriteria"%>
<%@page import="it.beije.turing.web.rubrica.EntityManagerSingleton"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Contatti trovati:
	<br>
	<%
	List<Contatto> contatti = (List<Contatto>) request.getAttribute("contatti");
	if (contatti != null) {
		for (Contatto c : contatti) {
			out.println(c);
	%>
	<br>
	<%
	}

	}
	else{
		out.println("Nessun contatto trovato.");
	}
	%>
	<form name="loginForm" method="get"
		action="http://localhost:8080/turing/rubrica.jsp">
		<input type="submit" value="Torna alla home" />
	</form>
</body>
</html>