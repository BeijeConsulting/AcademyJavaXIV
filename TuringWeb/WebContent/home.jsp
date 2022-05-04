<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.JPAcriteriaManager"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Beije Rubrica</title>
		<style type="text/css">
			h1, tr {
				text-align:center;
			}
			
			.container, .mini_container {
				display:flex;
				justify-content:space-between;
				width:50%;
				margin:auto;
				margin-bottom:30px;
			}
			.mini_container {
				justify-content:flex-start;
			}
			
			input {
				padding:10px;
				font-size:20px;
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
			
			.idInput{
				display: flex;
			}
			
			.order {
				font-size:10px;
				padding:5px;
				margin-right:10px;
			}
		</style>
	</head>
	<body>
		<h1>Gestore rubrica</h1>
		<br>
		
		<div class="container">
			<form action="./search.jsp">
				<input type="submit" value="Cerca contatto">
			</form>
			<form action="./insert.jsp">
				<input type="submit" value="Inserisci contatto">
			</form>
			<form action="./modify" class="idInput">
				<input type="submit" value="Modifica contatto">
	  			<input type="text" id="id" name="id" value="" placeholder="Id da modificare:"><br>
			</form>
		</div>
		
		<div class="container">
			<form action="./finddup">
				<input type="submit" value="Cerca contatti duplicati">
			</form>
			<form action="./delete" class="idInput">
				<input type="submit" value="Elimina contatto">
				<input type="text" id="id" name="id" value="" placeholder="Id da eliminare:"><br>
			</form>
			<form action="./mergedup">
				<input type="submit" value="Unisci contatti duplicati">
			</form>
		</div>
		
		<div class="mini_container">
			<form action="./index">
				<input type="submit" class="order" value="Ordina per id">
			</form>
			<form action="./index">
				<input type="hidden" name="order" value="nome">
				<input type="submit" class="order" value="Ordina per nome">
			</form>
			<form action="./index">
				<input type="hidden" name="order" value="cognome">
				<input type="submit" class="order" value="Ordina per cognome">
			</form>
		</div>
		 
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
		
				
				
				<%List<Contatto> contatti = (ArrayList<Contatto>) session.getAttribute("contatti");
				if(contatti != null) {
					for(Contatto contatto : contatti) { %>
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
					<%}
				} else {%>
					<jsp:forward page="/index" />
				<%} %>
				
			</table>
		</div>
	</body>
</html>