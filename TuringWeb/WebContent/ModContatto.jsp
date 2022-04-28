<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="it.beije.turing.web.rubrica.CommandInterface" %>
<%@page import ="it.beije.turing.web.rubrica.bean.Contatto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="list" type="java.util.List<Contatto>" scope="session" ></jsp:useBean>
<%
	out.println("<table>");
	out.println("<tr>");
	out.println("<th>ID</th>");
	out.println("<th>Nome</th>");
	out.println("<th>Cogome</th>");
	out.println("<th>Telefono</th>");
	out.println("</tr>");
	for(Contatto c : list)
	{
		out.println("<tr>");
		out.println("<td>"+c.getId()+"</td>");
		out.println("<td>"+c.getNome()+"</td>");
		out.println("<td>"+c.getCognome()+"</td>");
		out.println("<td>"+c.getTelefono()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	%>
	
<%if(session.getAttribute("mode")==null||session.getAttribute("mode").toString().equalsIgnoreCase("main"))
	{
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"new\">");
	out.println("<input type=\"submit\" value=\"new\">");
	out.println("</form>");
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"delete\">");
	out.println("<input type=\"submit\" value=\"delete\">");
	out.println("</form>");
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"back\">");
	out.println("<input type=\"submit\" value=\"Back\">");
	out.println("</form>");
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"modify\">");
	out.println("<input type=\"submit\" value=\"modify\">");
	out.println("</form>");
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"search\">");
	out.println("<input type=\"submit\" value=\"Search\">");
	out.println("</form>");
	}
 else if(session.getAttribute("mode").toString().equalsIgnoreCase("add")) 
{
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"new\">");
	out.println("<input type= \"hidden\" id=\"flag\" name=\"flag\" value=\"true\">");
	out.println("<input type=\"text\" id=\"nome\" name=\"nome\" value=\"nome\">");
	out.println("<input type=\"text\" id=\"conome\" name=\"cognome\" value=\"cognome\">");
	out.println("<input type=\"text\" id=\"email\" name=\"email\" value=\"email\">");
	out.println("<input type=\"text\" id=\"telefono\" name=\"telefono\" value=\"telefono\">");
	out.println("<input type=\"text\" id=\"note\" name=\"note\" value=\"note\">");
	out.println("<br><br>");
	out.println("<input type=\"submit\" value=\"Submit\">");
	out.println("</form>");
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"back\">");
	out.println("<input type=\"submit\" value=\"Back\">");
	out.println("</form>");
}
 else if(session.getAttribute("mode").toString().equalsIgnoreCase("delete")) {
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"delete\">");
	out.println("<input type= \"hidden\" id=\"flag\" name=\"flag\" value=\"true\">");
	out.println("<input type=\"text\" id=\"id\" name=\"id\" value=\"id\">");
	out.println("<input type=\"submit\" value=\"Submit\">");
	out.println("</form>");
	
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"back\">");
	out.println("<input type=\"submit\" value=\"Back\">");
	out.println("</form>");
 }
%>
</body>
</html>