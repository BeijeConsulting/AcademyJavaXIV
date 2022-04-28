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
	<%="Aggiungi Contatto"%>
	<br>
	<%="session: " + session.getId()%>
	<br>
	<%
	String name = (String)session.getAttribute("name");
	String surname = (String)session.getAttribute("lname");
	String tel = (String)session.getAttribute("tel");
	String email = (String)session.getAttribute("email");
	String note =(String)session.getAttribute("note");
	List<Contatto> ris = rm.AggiungiContatto(name, surname, tel, email, note);
	%>
	<%="Contatto aggiunto: "+ ris.get(ris.size()-1) %><br>
	<%
	rm.setAllContatti(rm.writeRubricaOnDB(ris));
	%>
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