
<%@page import="it.beije.turing.web.JPARubricaManager"%>
<%@page import="it.beije.turing.web.Contatto"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
int x = 1;
int y = 4;
int z = x + y;

out.println("z = " + z);

request.getSession();

String nome = (String) session.getAttribute("nome");
String cognome = (String) session.getAttribute("cognome");

Contatto contatto = new Contatto();

contatto.setNome(nome);
contatto.setCognome(cognome);

out.println(contatto.toString());







//out.print("z = " + z);
%>
<br>
<%-- 
x + y =&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%= x + y %><br>
<% for (char a = 'a'; a <= 'z'; a++) { %>
	<%= a %>
	
<% } %>
<br>
<%= x + 3 %>
<br>
--%>

FNAME = <%= nome %><br>
LNAME = <%= cognome %>



</body>
</html>