<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.JpaManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name= "loginForm" method= "post" action="http://localhost:8080/turing/ServletAggiungi">
		Nome<input type= "text" name="nome"/> <br />
		Cognome<input type= "text" name= "cognome"/> <br />
		Telefono<input type= "text" name= "telefono"/> <br />
		Email<input type= "text" name= "email"/> <br />
		Note<input type= "text" name= "note"/> <br />
		<input type="submit" value="Inserisci" />
	</form>
</body>
</html>