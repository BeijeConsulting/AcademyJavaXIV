<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Beije Rubrica</title>
		<style type="text/css">
			h1 {
				text-align:center;
			}
			
			.container {
				display:flex;
				justify-content:center;
				width:50%;
				margin:auto;
				margin-bottom:30px;
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
		</style>
	</head>
	<body>
		<h1>Benvenuto nel tuo gestore rubrica</h1>
		<br>
		
		<div class="container">
			<form action="./home">
				<input type="hidden" name="order" value="">
				<input type="submit" value="Entra nel gestore">
			</form>
		</div>
		
		
	</body>
</html>