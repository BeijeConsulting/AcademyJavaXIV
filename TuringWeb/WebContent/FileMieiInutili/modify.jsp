<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.RubricaManager"%>
<%@page import="java.util.List"%>
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
	<jsp:useBean id="contatto" class="it.beije.turing.web.rubrica.Contatto" scope="session"></jsp:useBean>
	<%
		List<Contatto> tmp = rm.getAllContatti();
		List<Contatto> ris = rm.ModificaContatto(tmp,contatto);
		rm.setAllContatti(ris);
		rm.writeRubricaOnDB(rm.getAllContatti());
		response.sendRedirect("./index.html");
	%>
	

</body>
</html>