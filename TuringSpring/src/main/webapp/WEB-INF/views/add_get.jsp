<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo Contatto</title>
</head>
<body bgcolor="#0F0F0F">
<font color=#FFFFFF>
<div align="center">
<h1>Aggiungi Contatto</h1>
<p>Inserire i dati da salvare su DB:</p>
<form action="./add" method="post">
  <label for="name">First name:</label><br>
  <input type="text" id="name" name="name"><br>
  <label for="lname">Last name:</label><br>
  <input type="text" id="lname" name="lname"><br>
  <label for="tel">Telephone Number:</label><br>
  <input type="text" id="tel" name="tel"><br>
  <label for="email">Email:</label><br>
  <input type="text" id="email" name="email"><br>
  <label for="note">Note:</label><br>
  <input type="text" id="note" name="note"><br>
  <input type="submit" value="Submit"><br>
 </form>
 </div>
 </font>
</body>
</html>