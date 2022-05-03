<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<c:choose>
					<c:when test="${empty contattiTrovati}"><h3>Nessun contatto con i dati precedentemente inseriti e' stato trovato nella rubrica.</h3></c:when>
					<c:otherwise>
						<c:forEach items="${contattiTrovati}" var="contatto">
							<tr>
								<td>${contatto.id}</td>
								<td>${contatto.nome}</td>
								<td>${contatto.cognome}</td>
								<td>${contatto.indirizzo}</td>
								<td>${contatto.dataDiNascita}</td>
								<td>${contatto.email}</td>
								<td>${contatto.telefono}</td>
								<td>${contatto.note}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		
		<form action="./home">
			<input type="hidden" name="order" value="">
			<input type="submit" class="esc" value="Torna alla home">
		</form>
	</body>
</html>