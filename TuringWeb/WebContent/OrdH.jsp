<%@page import="it.beije.turing.ecomm.beans.Client"%>
<%@page import="java.util.List"%>
<%@page import="it.beije.turing.ecomm.beans.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	List<Order> list = (List<Order>)session.getAttribute("olist");
	if(list==null)
	{
		response.sendRedirect("./emain");
	}
	else{
	out.println("<table>");
	out.println("<tr>");
	out.println("<th>ID</th>");
	out.println("<th>Cliente</th>");
	out.println("<th>Valore</th>");
	out.println("<th>Stato</th>");
	out.println("</tr>");
	for(Order c : list)
	{
		out.println("<tr>");
		out.println("<td>"+c.getId()+"</td>");
		out.println("<td>"+c.getIdCliente().getNome()+" "+c.getIdCliente().getCognome()+"</td>");
		out.println("<td>"+c.getValoreTotale()+"</td>");
		out.println("<td>"+c.getStato()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
	}
	%>
<%
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
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"search\">");
	out.println("<input type=\"submit\" value=\"Search\">");
	out.println("</form>");
	%>

</body>
</html>