<%@page import="it.beije.turing.web.rubrica.ServletMostra"%>
<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.JPACriteria"%>
<%@page import="it.beije.turing.web.rubrica.EntityManagerSingleton"%>
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
ServletMostra.writer(JPACriteria.findAll(EntityManagerSingleton.createEntityManager(), 0) ,response);
%>
</body>
</html>