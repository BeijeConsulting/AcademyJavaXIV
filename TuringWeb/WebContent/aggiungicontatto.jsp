<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.JpaManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form name= "loginForm" method= "get" action="aggiungicontatto.jsp">
		Nome<input type= "text" name="nome"/> <br />
		Cognome<input type= "text" name= "cognome\"/> <br />
		Telefono<input type= "text\" name= "telefono"/> <br />
		Email<input type= "text\" name= "email"/> <br />
		Note<input type= "text\" name= "note"/> <br />
		<input type="submit" value="Inserisci" />
	</form>
	<%
	Contatto contatto = new Contatto();
	contatto.setNome(request.getParameter("nome"));
	contatto.setCognome(request.getParameter("cognome"));
	contatto.setEmail(request.getParameter("email"));
	contatto.setTelefono(request.getParameter("telefono"));
	contatto.setNote(request.getParameter("note"));
	
	if(contatto.getNome() != null){
		JpaManager.addContatti(contatto);
		response.sendRedirect("http://localhost:8080/turing/mostracontatti.jsp");
	}
		
	
	%>
	

</body>
</html>