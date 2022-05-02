<%@page import="it.beije.turing.web.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Contatto</title>
</head>
<body>
inserito nuovo contatto<br>
<% out.println((Contatto)request.getAttribute("contatto"));


%>
<form action="./index.jsp" method="GET">
<br>
    <input type="submit" name="submit" value="Back to home page">
</form>
</body>
</html>