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
<%CommandInterface link = CommandInterface.getInstance();
	for(Contatto c : link.getList())
	{
		out.println(c);
		out.println("<br>");
	}
	%>
	
<%if(session.getAttribute("mode")==null||session.getAttribute("mode").toString().equalsIgnoreCase("main"))
	{
		out.println("<form action=\"./main\" method=\"post\"><input type=\"text\" id=\"command\" name=\"command\" value=\"\"><br><br><input type=\"submit\" value=\"Submit\"></form>");
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