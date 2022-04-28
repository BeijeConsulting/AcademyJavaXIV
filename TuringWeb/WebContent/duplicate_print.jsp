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
	<%="Stampa contatti duplicati e uniscili"%>
	<br>
	<%="session: " + session.getId()%>
	<br>
	<%
	List<Contatto> tmp = rm.TrovaContattiDuplicati(rm.getAllContatti());
	List<Contatto> allContatti = rm.getAllContatti();
	List<Contatto> ris = rm.UnisciContattiDuplicati(allContatti);
	rm.setAllContatti(ris);
	rm.writeRubricaOnDB(rm.getAllContatti());
	%>
	<%="Contatti duplicati:"%>
	<br>
	<%
	for (Contatto c : tmp) {
	%>
	<%=c.toString()%><br>
	<%
	}
	%>
	<%="Nuova lista contatti:"%>
	<br>
	<%
	for (Contatto c : rm.getAllContatti()) {
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