<%@page import="it.beije.turing.web.ecomm.beans.Client"%>
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

<%
	Client contatto = (Client)session.getAttribute("client");
	
	if(contatto == null)
	{
		request.getRequestDispatcher("/emain").forward(request,response);
	}
	else{

	out.println("<form action=\"./emain\" method=\"post\">");
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
	out.println("<input type=\"text\" id=\"telefono\" name=\"telefono\" value=\""+contatto.getIndirizzo()+"\"><br>");
			

	
	out.println("<br><br>");
	out.println("<input type=\"submit\" value=\"Submit\">");
	out.println("</form>");
	
	
	out.println("<form action=\"./emain\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"back\">");
	out.println("<input type=\"submit\" value=\"Back\">");
	out.println("</form>");
	
	session.setAttribute("client", null);
	}
%>
</body>
</html>