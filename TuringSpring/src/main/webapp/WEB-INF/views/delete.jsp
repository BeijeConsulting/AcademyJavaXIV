<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<c:choose>
			<c:when test="${empty contatto}">
				<h3>Nessun contatto con id ${id} e' stato trovato nella rubrica.</h3>
				<div class="container">	
					<form action="./home">
						<input type="hidden" name="order" value="">
						<input type="submit" class="esc" value="Torna alla home">
					</form>
				</div>
			</c:when>
			<c:otherwise>
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
							<td>${contatto.id}</td>
							<td>${contatto.nome}</td>
							<td>${contatto.cognome}</td>
							<td>${contatto.indirizzo}</td>
							<td>${contatto.dataDiNascita}</td>
							<td>${contatto.email}</td>
							<td>${contatto.telefono}</td>
							<td>${contatto.note}</td>
						</tr>
					</table>
					<div class="container">	
						<form action="./delete" method="post">
							<input type="hidden" id="id" name="id" value="${id}">
							<input type="submit" class="esc" value="Si">
						</form>
						<form action="./home">
							<input type="hidden" name="order" value="">
							<input type="submit" class="esc" value="No">
						</form>
					</div>
				</div>
			</c:otherwise>
		</c:choose>

	</body>
</html>