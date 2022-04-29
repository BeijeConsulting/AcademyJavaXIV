<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="it.beije.turing.web.rubrica.Contatto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Il seguente contatto è stato aggiunto con successo: <br>
<%
Contatto c = (Contatto)request.getAttribute("contatto");
out.println(c);
%>
<form name="loginForm" method="get"
		action="http://localhost:8080/turing/rubrica.jsp">
		<input type="submit" value="Torna alla home" />
	</form>
</body>
</html>