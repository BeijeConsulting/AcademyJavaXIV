<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Rubrica cerca contatto</title>
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
		<h1>Inserisci dati del contatto da cercare</h1>
		<form action="./search" method="post">
			<div class="container">					
				<label for="name">Nome:</label><br>
	  			<input type="text" id="name" name="name" value=""><br>
	  			
	  			<label for="surname">Cognome:</label><br>
	  			<input type="text" id="surname" name="surname" value=""><br>
			</div>
			<input type="submit" class="esc" value="Cerca contatto">
		</form>
		<form action="./index" method="post">
			<input type="submit" class="esc" value="Torna alla home">
		</form>
	</body>
</html>