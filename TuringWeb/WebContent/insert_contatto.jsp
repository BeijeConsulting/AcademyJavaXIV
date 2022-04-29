<%@page import="main.java.it.beije.turing.JPAContactsManager.Contatto"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Contatto</title>
</head>
<body>

<jsp:useBean id="contatto" type="java.util.List<main.java.it.beije.turing.JPAContactsManager.Contatto>" scope="session"></jsp:useBean>
<%--
Contatto contatto = (Contatto) session.getAttribute("contatto");
if (contatto == null) {
	contatto = new Contatto();
	session.setAttribute("contatto", contatto);
}
--%>

<jsp:setProperty property="nome" name="contatto" param="name"/>
<%--
String nome = request.getParameter("name");
if (nome != null) contatto.setNome(nome);
--%>
<jsp:setProperty property="cognome" name="contatto" param="cognome"/>

NOME : <jsp:getProperty name="contatto" property="nome"/><br>
COGNOME : <jsp:getProperty name="contatto" property="cognome"/>

</body>
</html>