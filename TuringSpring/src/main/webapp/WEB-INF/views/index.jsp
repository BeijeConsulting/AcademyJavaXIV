<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body bgcolor="#0F0F0F">

<br>
<br>
<font color=#FFFFFF>
<div align="center">

<h1>Rubrica Tomcat<br></h1>
<h3>Seleziona un'azione<br></h3>
<br>
<form action="./print" method="get">
<label for="print">Stampa Tutti i contatti:     </label>
  <input type="submit" id="print" name="type" value="Stampa Tutti i contatti"><br>
  <br>
 </form>
 <form action="./search" method="get">
<label for="search">Cerca contatto:     </label>
  <input type="submit" id="search" name="type" value="Cerca contatto"><br>
  <br>
 </form>
 <form action="./add" method="get">
<label for="add">Aggiungi contatto:     </label>
  <input type="submit" id="add" name="type" value="Aggiungi contatto"><br>
  <br>
 </form>
 <form action="./remove" method="get">
<label for="remove">Rimuovi contatto:     </label>
  <input type="submit" id="remove" name="type" value="Rimuovi contatto"><br>
  <br>
 </form>
 <form action="./modify" method="get">
<label for="modify">Modifica contatto:     </label>
  <input type="submit" id="modify" name="type" value="Modifica contatto"><br>
  <br>
 </form>
 <form action="./merge" method="get">
<label for="merge">Unisci contatti duplicati:     </label>
  <input type="submit" id="merge" name="type" value="Unisci contatti duplicati"><br>
  <br>
 </form>
</div>
</font>

</body>
</html>