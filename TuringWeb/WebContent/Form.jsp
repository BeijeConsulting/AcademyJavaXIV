<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import ="it.beije.turing.web.rubrica.bean.Contatto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="contatto" class="it.beije.turing.web.rubrica.bean.Contatto" scope="session"></jsp:useBean>
<%
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\""+session.getAttribute("type")+"\">");
	out.println("<input type= \"hidden\" id=\"flag\" name=\"flag2\" value=\"true\">");
	
	out.println("<input type=\"hidden\" id=\"id\" name=\"id\" value=\""+contatto.getId()+"\">");
			
	
	out.println( "<label for=\"nome\">Nome</label>");
	out.println("<input type=\"text\" id=\"nome\" name=\"nome\" value=\""+contatto.getNome()+"\"><br>");
			
	out.println( "<label for=\"cognome\">Cognome</label>");
	out.println("<input type=\"text\" id=\"cognome\" name=\"cognome\" value=\""+contatto.getCognome()+"\"><br>");
			
	out.println( "<label for=\"email\">Email</label>");
	out.println("<input type=\"text\" id=\"email\" name=\"email\" value=\""+contatto.getEmail()+"\"><br>");
	
	out.println( "<label for=\"telefono\">Telefono</label>");
	out.println("<input type=\"text\" id=\"telefono\" name=\"telefono\" value=\""+contatto.getTelefono()+"\"><br>");
			
	out.println( "<label for=\"note\">Note</label>");
	out.println("<input type=\"text\" id=\"note\" name=\"note\" value=\""+contatto.getNote()+"\"><br>");
	
	
	
	
	out.println("<br><br>");
	out.println("<input type=\"submit\" value=\"Submit\">");
	out.println("</form>");
	
	
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"back\">");
	out.println("<input type=\"submit\" value=\"Back\">");
	out.println("</form>");

%>
</body>
</html>