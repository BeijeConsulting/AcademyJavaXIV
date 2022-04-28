<%@page import="it.beije.turing.web.rubrica.Contatto"%>
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

System.out.println("z = " + z);

//request.getSession();
String fname = (String)session.getAttribute("fname");
String lname = (String)session.getAttribute("lname");


//Contatto contatto = new Contatto();

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
--%>
FNAME = <%= fname %><br>
LNAME = <%= lname %>

</body>
</html>