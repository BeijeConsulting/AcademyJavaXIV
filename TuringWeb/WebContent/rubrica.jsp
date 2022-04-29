<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="loginForm" method="get"
		action="http://localhost:8080/turing/aggiungicontatto.jsp">
		<input type="submit" value="Aggiungi contatto" />
	</form>
	<br>
	<form name="loginForm" method="get"
		action="http://localhost:8080/turing/trova_contatto.jsp">
		<input type="submit" value="Trova contatto" />
	</form>
	<br>
	<form name="loginForm" method="get"
		action="http://localhost:8080/turing/ServletMostra">
		<input type="submit" value="Mostra tutti i contatti" />
	</form>
	<br>
	<form name="loginForm" method="get"
		action="http://localhost:8080/turing/modifica_contatto.jsp">
		<input type="submit" value="Modifica contatto esistente" />
	</form>
	<br>
	<form name="loginForm" method="get"
		action="http://localhost:8080/turing/elimina_contatto.jsp">
		<input type="submit" value="Elimina contatto" />
	</form>
	<br>
	<form name="loginForm" method="get"
		action="http://localhost:8080/turing/ServletContattiDoppi">
		<input type="submit" value="Trova contatti duplicati" />
	</form>
</body>
</html>