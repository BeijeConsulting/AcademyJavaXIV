<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.JPAcriteriaManager"%>
<%@page import="it.beije.turing.web.rubrica.JPAentityManagerFactory"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Rubrica elimina contatto</title>
		<style type="text/css">
			h1, h3, td{
				text-align:center;
			}
			label {
				font-size:20px;
			}
			.container {
				width: 55%;
				margin:auto;
				display:flex;
				justify-content:center;
			}
			table {
				width:100%;
			}
			table{
				width:100%;
				background-color:lightgray;
			}
			
			th {
				background-color:rgb(229,228,226);
			}
			
			td {
				padding: 5px 0;
				background-color:white;
			}
			
			table, th, td {
			  	border: 1px solid gray;
			}
			input {
				display:block;
				text-align:center;
				width:200px;
				margin: 10px;
				padding:10px;
				font-size:15px;
				border-radius:10px;
				box-shadow: 0px 2px 5px gray;
				border: none;
				border: 1px solid black;
				cursor: pointer;
				transition: 0.5s;
			}
			input[type=submit]:hover{
				transform: scale(1.1);
			}
		</style>
	<head>
	<body>
	
		<%int id = Integer.parseInt((String) session.getAttribute("id"));
		Contatto contatto = (Contatto) session.getAttribute("contatto");%>
		
		
		<%if(contatto != null) {%>
			<h1>Sei sicuro di voler eliminare questo contatto?</h1>
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
				</table>
			</div>
			<div class="container">	
				<form action="./delete" method="post">
					<input type="hidden" id="id" name="id" value="<%= id%>">
					<input type="submit" class="esc" value="Si">
				</form>
				<form action="./index" method="post">
					<input type="submit" class="esc" value="No">
				</form>
			</div>
		<%} else {%>
			<h3>Nessun contatto con id <%=id%> e' stato trovato nella rubrica.</h3>
			<div class="container">	
				<form action="./index" method="post">
					<input type="submit" class="esc" value="Torna alla home">
				</form>
			</div>
		<%}%>
		
		<%request.getSession().setAttribute("contatto", null);
		request.getSession().setAttribute("id", null);%>
		
	</body>
</html>