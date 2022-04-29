<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.rubrica.JPAcriteriaManager"%>
<%@page import="it.beije.turing.web.rubrica.JPAentityManagerFactory"%>
<%@page import="java.util.List" %>
<%@page import="javax.persistence.EntityManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Rubrica modifica contatto</title>
		<style type="text/css">
			h1{
				text-align:center;
			}
			label {
				font-size:15px;
				display:flex;
				align-items:center;
			}
			.container {
				width: 55%;
				margin:auto;
				display:flex;
				justify-content:space-between;
			}
			input {
				display:block;
				text-align:center;
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
			input[type=submit]:hover{
				transform: scale(1.1);
			}
			
		</style>
	<head>
	<body>
	
		<%int id = Integer.parseInt((String) session.getAttribute("id"));
		Contatto contatto = (Contatto) session.getAttribute("contatto");
		if(contatto == null) {
			contatto = new Contatto();
		}%>
		<h1>Modifica contatto</h1>
		<form action="./modify" method="post">
			<div class="container">					
				<label for="name">Nome:</label><br>
	  			<input type="text" id="name" name="name" value="<%= contatto.getNome()%>"><br>
	  			
	  			<label for="surname">Cognome:</label><br>
	  			<input type="text" id="surname" name="surname" value="<%= contatto.getCognome()%>"><br>
	  			
				<label for="address">Indirizzo:</label><br>
	  			<input type="text" id="address" name="address" value="<%= contatto.getIndirizzo()%>"><br>
	  			
	  			<label for="birthday">Data di nascita:</label><br>
	  			<input type="text" id="birthday" name="birthday" value="<%= contatto.getDataDiNascita()%>"><br>
			</div>
  			
  			<div class="container">	
				<label for="email">Email:</label><br>
	  			<input type="text" id="email" name="email" value="<%= contatto.getEmail()%>"><br>
	  			
	  			<label for="phone">Telefono:</label><br>
	  			<input type="text" id="phone" name="phone" value="<%= contatto.getTelefono()%>"><br>
	  			
				<label for="notes">Note:</label><br>
	  			<input type="text" id="notes" name="notes" value="<%= contatto.getNote()%>"><br>
  			</div>
  			
  			<input type="hidden" id="id" name="id" value="<%= id%>">
			<input type="submit" class="esc" value="Conferma le modifiche">
		</form>
		
		<%request.getSession().setAttribute("contatto", null);
		request.getSession().setAttribute("id", null);%>
		
		<form action="./index" method="post">
			<input type="submit" class="esc" value="Torna alla home">
		</form>
	</body>
</html>