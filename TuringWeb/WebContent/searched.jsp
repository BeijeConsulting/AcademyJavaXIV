<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.JPAcriteriaManager"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Rubrica contatti trovati</title>
		<style type="text/css">
			h1, h3, tr{
				text-align:center;
			}
			label {
				font-size:20px;
			}
			.container {
				width: 55%;
				margin:auto;
				display:flex;
				justify-content:space-between;
			}
			table {
				width:100%;
			}
			input {
				display:block;
				width:200px;
				margin: 10px auto;
				padding:10px;
				font-size:15px;
				border-radius:10px;
				box-shadow: 0px 2px 5px gray;
				border: none;
				border: 1px solid black;
				transition: 0.5s;
				cursor:pointer;
			}
			input[type=submit]:hover {
				transform: scale(1.1);
			}
		</style>
	<head>
	<body>
		<h1>Contatti trovati</h1>
		
		<%String name = (String)request.getParameter("name");
		String surname = (String)request.getParameter("surname");
		
		List<Contatto> contatti = JPAcriteriaManager.getRubrica();
		List<Contatto> contattiTrovati = new ArrayList<>();
		
		for(Contatto contatto : contatti) {
			if(name.equals(contatto.getNome()) && surname.equals(contatto.getCognome())) {
				contattiTrovati.add(contatto);
			}
		}%>
		
		<%if(contattiTrovati.size() >= 1) {%>
			<div class="container">
				<table>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Indirizzo</th>
						<th>Data di nascita</th>
						<th>Email</th>
						<th>Telefono</th>
						<th>Note</th>
					</tr>
					<%for(Contatto contatto : contattiTrovati) { %>
						<tr>
							<td><%=contatto.getId()%></td>
							<td><%=contatto.getNome()%></td>
							<td><%=contatto.getCognome()%></td>
							<td><%=contatto.getIndirizzo()%></td>
							<td><%=contatto.getDataDiNascita()%></td>
							<td><%=contatto.getEmail()%></td>
							<td><%=contatto.getTelefono()%></td>
							<td><%=contatto.getNote()%></td>
						</tr>
					<% } %>
				
				</table>
			</div>
		<%} else {%>
			<h3>Nessun <%= name %> <%= surname %> e' stato trovato nella rubrica.</h3>
		<%}%>
		
		
		<form action="./index.jsp" method="post">
			<input type="submit" class="esc" value="Torna alla home">
		</form>
	</body>
</html>