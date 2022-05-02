<%@page import="it.beije.turing.ecomm.beans.Transaction"%>
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
	Order contatto = (Order)session.getAttribute("Order");
	
	if(contatto == null)
	{
		request.getRequestDispatcher("/emain").forward(request,response);
	}
	else{
		
	List<Transaction> list = contatto.getCarrello();
	for(Transaction t : list)
	{
		out.println(t);
	}
	out.println("<form action=\"./emain\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"id\" name=\"id\" value=\"" + contatto.getId()+ "\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"addTransaction\">");
	out.println("<input type=\"submit\" value=\"new Item\">");
	out.println("</form>");
	
	out.println("<form action=\"./emain\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\"delT\">");
	out.println("<input type=\"submit\" value=\"DelItem\">");
	out.println("</form>");
	

	out.println("<form action=\"./emain\" method=\"post\">");
	out.println("<input type= \"hidden\" id=\"command\" name=\"command\" value=\""+session.getAttribute("type")+"\">");
	out.println("<input type= \"hidden\" id=\"flag\" name=\"flag2\" value=\"true\">");
	
	out.println("<input type=\"hidden\" id=\"id\" name=\"id\" value=\""+contatto.getId()+"\">");
			
	
	out.println( "<label for=\"nome\">Nome</label>");
	out.println("<input type=\"text\" id=\"nome\" name=\"nome\" value=\""+contatto.getIdCliente().getCognome()+"\"><br>");
			
	out.println( "<label for=\"cognome\">Cognome</label>");
	out.println("<input type=\"text\" id=\"cognome\" name=\"cognome\" value=\""+contatto.getValoreTotale()+"\"><br>");
			
	out.println( "<label for=\"email\">Email</label>");
	out.println("<input type=\"text\" id=\"email\" name=\"email\" value=\""+contatto.getStato()+"\"><br>");
	
	
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