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
	<jsp:useBean id="contatto" class="it.beije.turing.web.rubrica.Contatto" scope="session"></jsp:useBean>
	<%
	List<Contatto> ris = rm.cercaContatto(contatto.getNome(), contatto.getCognome(), contatto.getTelefono(), contatto.getEmail());
	%>
	
	<%="Serched: "+contatto.getNome()+" "+contatto.getCognome()+" "+contatto.getTelefono()+" "+contatto.getEmail()+" "%><br>
	<%
	for (Contatto c : ris) {
	%>
	<%=c.toString()%><br>
	<%
	}
	%>
	<br>
	
	<form action="./index.html" method="post">
 		<label for="merge">Torna alla Home:     </label>
  		<input type="submit" id="merge" name="type" value="Submit"><br>
  	</form>
	
</body>
</html>