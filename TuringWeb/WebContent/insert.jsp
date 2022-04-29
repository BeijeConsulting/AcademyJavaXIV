<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Rubrica inserisci contatto</title>
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
		<h1>Inserisci contatto</h1>
		
		<form action="./insert" method="post">
			<div class="container">					
				<label for="name">Nome:</label><br>
	  			<input type="text" id="name" name="name" value=""><br>
	  			
	  			<label for="surname">Cognome:</label><br>
	  			<input type="text" id="surname" name="surname" value=""><br>
	  			
				<label for="address">Indirizzo:</label><br>
	  			<input type="text" id="address" name="address" value=""><br>
	  			
	  			<label for="birthday">Data di nascita:</label><br>
	  			<input type="text" id="birthday" name="birthday" value=""><br>
			</div>
  			
  			<div class="container">	
				<label for="email">Email:</label><br>
	  			<input type="text" id="email" name="email" value=""><br>
	  			
	  			<label for="phone">Telefono:</label><br>
	  			<input type="text" id="phone" name="phone" value=""><br>
	  			
				<label for="notes">Note:</label><br>
	  			<input type="text" id="notes" name="notes" value=""><br>
  			</div>
  			
			<input type="submit" class="esc" value="Inserisci contatto">
		</form>
		<form action="./index" method="post">
			<input type="submit" class="esc" value="Torna alla home">
		</form>
	</body>
</html>