<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seleziona Metodo Ordinamento</title>
</head>
<body bgcolor="#0F0F0F">
<font color=#FFFFFF>
<div align="center">
<h1>Stampa</h1>
<p>Seleziona ordine di stampa:</p>
<form action="./print" method="post">
<input type="radio" id="type" name="type" value="Name">
  <label for="namebutton">Name</label><br>
  <input type="radio" id="type" name="type" value="Surname">
  <label for="surnamebutton">Surname</label><br>
  <input type="submit" value="Submit"><br>
 </form>
 </div>
 </font>
</body>
</html>