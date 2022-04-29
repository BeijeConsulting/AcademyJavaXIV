<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="it.beije.turing.web.rubrica.CommandInterface" %>
<%@page import ="it.beije.turing.web.ecomm.beans.Client" %>
<%@page import = "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	List<Client> list = (List<Client>)session.getAttribute("list");
	if(list==null)
	{
		response.sendRedirect("./emain");
	}
	else{
	out.println("<table>");
	out.println("<tr>");
	out.println("<th>ID</th>");
	out.println("<th>Nome</th>");
	out.println("<th>Cogome</th>");
	out.println("<th>Indirizzo</th>");
	out.println("</tr>");
	for(Client c : list)
	{
		out.println("<tr>");
		out.println("<td>"+c.getId()+"</td>");
		out.println("<td>"+c.getNome()+"</td>");
		out.println("<td>"+c.getCognome()+"</td>");
		out.println("<td>"+c.getIndirizzo()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	}
	%>
	
<%if(session.getAttribute("mode")==null||session.getAttribute("mode").toString().equalsIgnoreCase("main"))
	{
	out.println("<form action=\"./emain\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"new\">");
	out.println("<input type=\"submit\" value=\"new\">");
	out.println("</form>");
	
	
	out.println("<form action=\"./emain\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"delete\">");
	out.println("<input type=\"submit\" value=\"delete\">");
	out.println("</form>");
	
	
	out.println("<form action=\"./emain\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"back\">");
	out.println("<input type=\"submit\" value=\"Back\">");
	out.println("</form>");
	
	
	out.println("<form action=\"./emain\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"modify\">");
	out.println("<input type=\"submit\" value=\"modify\">");
	out.println("</form>");
	
	
	out.println("<form action=\"./emain\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"addOrder\">");
	out.println("<input type=\"submit\" value=\"AddOrder\">");
	out.println("</form>");
	
	
	out.println("<form action=\"./emain\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"orders\">");
	out.println("<input type=\"submit\" value=\"Order History\">");
	out.println("</form>");
	
	out.println("<form action=\"./emain\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"showOrders\">");
	out.println("<input type=\"submit\" value=\"Client's orders\">");
	out.println("</form>");
	}
 else if(session.getAttribute("mode").toString().equalsIgnoreCase("add")) 
{
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"new\">");
	out.println("<input type= \"hidden\" id=\"flag\" name=\"flag\" value=\"true\">");
	
	out.println( "<label for=\"nome\">Nome</label>");
	out.println("<input type=\"text\" id=\"nome\" name=\"nome\" value=\"\"><br>");
			
	out.println( "<label for=\"cognome\">Cognome</label>");
	out.println("<input type=\"text\" id=\"cognome\" name=\"cognome\" value=\"\"><br>");
			
	out.println( "<label for=\"email\">Email</label>");
	out.println("<input type=\"text\" id=\"email\" name=\"email\" value=\"\"><br>");
	
	out.println( "<label for=\"telefono\">Telefono</label>");
	out.println("<input type=\"text\" id=\"telefono\" name=\"telefono\" value=\"\"><br>");
			
	out.println( "<label for=\"note\">Note</label>");
	out.println("<input type=\"text\" id=\"note\" name=\"note\" value=\"\"><br>");
	
	
	
	
	out.println("<br><br>");
	out.println("<input type=\"submit\" value=\"Submit\">");
	out.println("</form>");
	
	
	out.println("<form action=\"./emain\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"back\">");
	out.println("<input type=\"submit\" value=\"Back\">");
	out.println("</form>");
}
 else if(session.getAttribute("mode").toString().equalsIgnoreCase("delete")) {
	out.println("<form action=\"./main\" method=\"post\">");
	
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"delete\">");
	out.println("<input type= \"hidden\" id=\"flag\" name=\"flag\" value=\"true\">");
	
	out.println( "<label for=\"id\">ID to delete</label>");
	out.println("<input type=\"text\" id=\"id\" name=\"id\" value=\"\">");
			
	out.println("<input type=\"submit\" value=\"Submit\">");
	out.println("</form>");
	
	
	
	out.println("<form action=\"./main\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"back\">");
	out.println("<input type=\"submit\" value=\"Back\">");
	out.println("</form>");
 }
 else if(session.getAttribute("mode").toString().equalsIgnoreCase("modify")) {
		out.println("<form action=\"./main\" method=\"post\">");
		
		out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"modify\">");
		out.println("<input type= \"hidden\" id=\"flag\" name=\"flag\" value=\"true\">");
		
		out.println( "<label for=\"id\">ID to modify</label>");
		out.println("<input type=\"text\" id=\"id\" name=\"id\" value=\"\">");
				
		out.println("<input type=\"submit\" value=\"Submit\">");
		out.println("</form>");
		
		
		
		out.println("<form action=\"./main\" method=\"post\">");
		out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"back\">");
		out.println("<input type=\"submit\" value=\"Back\">");
		out.println("</form>");
 }
 else if(session.getAttribute("mode").toString().equalsIgnoreCase("showOrders")) {
		out.println("<form action=\"./emain\" method=\"post\">");
		
		out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"showOrders\">");
		out.println("<input type= \"hidden\" id=\"flag\" name=\"flag\" value=\"true\">");
		
		out.println( "<label for=\"id\">Client's Id</label>");
		out.println("<input type=\"text\" id=\"id\" name=\"id\" value=\"\">");
				
		out.println("<input type=\"submit\" value=\"Submit\">");
		out.println("</form>");
		
		
		
		out.println("<form action=\"./emain\" method=\"post\">");
		out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"back\">");
		out.println("<input type=\"submit\" value=\"Back\">");
		out.println("</form>");
}
 else if(session.getAttribute("mode").toString().equalsIgnoreCase("addOrder")) {
		out.println("<form action=\"./emain\" method=\"post\">");
		
		out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"addOrder\">");
		out.println("<input type= \"hidden\" id=\"flag\" name=\"flag\" value=\"true\">");
		
		out.println( "<label for=\"id\">ID to modify</label>");
		out.println("<input type=\"text\" id=\"id\" name=\"id\" value=\"\">");
				
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