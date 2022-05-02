
<%@page import="it.beije.turing.web.rubrica.mvc.JPARubricaManager"%>
<%@page import="it.beije.turing.web.rubrica.mvc.Contatto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show</title>


</head>
<body>
<%

response.getWriter();
List<Contatto> cont = new ArrayList<>();

for(Contatto contatto : cont){
	out.print(contatto); %>

	<br>
	<%
}
%>
</form>









</body>
</html>