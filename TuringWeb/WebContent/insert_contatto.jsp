<%@page import="it.beije.turing.web.JPARubricaManager"%>
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
<form action="./test" method="get">
<jsp:useBean id="contatto" class="it.beije.turing.web.Contatto" scope="session"></jsp:useBean>
  <label for="nome">Nome:</label><br>
  <input type="text" id="nome" name="nome"><br>
<%
 contatto = (Contatto) session.getAttribute("contatto");
if(contatto == null){
	contatto = new Contatto();
	session.setAttribute("contatto", contatto);
}

%>

<jsp:setProperty property="nome" name="contatto" param="name" />
<%
String nome = request.getParameter("nome");
contatto.setNome("nome");
%>
<!--  
<jsp:setProperty property="cognome" name="contatto" param="cognome"/>
<%-- String cognome = request.getParameter("cognome");
contatto.setCognome("cognome"); --%>

NOME : <jsp:getProperty name="contatto" property="nome"/> <br>
COGNOME : <jsp:getProperty name="contatto" property="cognome"/> <br> -->
    
  <input type="submit" value="Submit">
</form> 
</body>
</html>