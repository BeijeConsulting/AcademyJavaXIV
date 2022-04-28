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
	<%="Stampa contatti"%>
	<br>
	<%="session: " + session.getId()%>
	<br>
	<%
	String value = (String)session.getAttribute("type");
	System.out.println(value);
	if (value == null) {
		value = "N";
	}
	rm.setAllContatti(rm.sort(rm.getAllContatti(), value));
	if (value.toUpperCase().startsWith("N")) {
	%>
	<%="Contatti ordinati per nome"%>
	<br>
	<%
	} else if (value.toUpperCase().startsWith("S")) {
	%>
	<%="Contatti ordinati per cognome"%>
	<br>
	<%
	}
	%>
	<%
	for (Contatto c : rm.getAllContatti()) {
	%>
	<%=c.toString()%><br>
	<%
	}
	%>
	<br>
	<%-- 
x + y =&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= x + y %><br>
<% for (char a = 'a'; a <= 'z'; a++) { %>
	<%= a %>
<% } %>
<br>
<%= x + 3 %>
--%>

</body>
</html>