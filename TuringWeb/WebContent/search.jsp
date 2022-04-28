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
<title>Insert title here</title>
</head>
<body>

	<%
	
	RubricaManager rm = new RubricaManager();
	%>
	<%="Cerca contatti"%>
	<br>
	<%="session: " + session.getId()%>
	<br>
	<%
	String name = (String)session.getAttribute("name");
	String surname = (String)session.getAttribute("lname");
	String tel = (String)session.getAttribute("tel");
	String email = (String)session.getAttribute("email");
	List<Contatto> ris = rm.cercaContatto(name, surname, tel, email);
	%>
	<%="Serched: "+name+" "+surname+" "+tel+" "+email+" "%><br>
	<%
	for (Contatto c : ris) {
	%>
	<%=c.toString()%><br>
	<%
	}
	%>
	<br>

</body>
</html>