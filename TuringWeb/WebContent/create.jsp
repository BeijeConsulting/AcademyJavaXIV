<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="style.css">
  <title>Crea Contatto | Java</title>
</head>
<body>

<%@ include file="header.jsp"%>

<h1>Crea nuovo contatto</h1>

<h2>Dati contatto</h2>
<div class="container">
  <form class="my_form" action="./create_contact" method="POST">
    <label for="fname">Nome:</label>
    <input type="text" id="fname" name="fname">
    <label for="lname">Cognome:</label>
    <input type="text" id="lname" name="lname">
    <label for="phone">Telefono:</label>
    <input type="text" id="phone" name="phone">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email">
    <label for="notes">Note:</label>
    <textarea id="notes" name="notes"></textarea>
    <input class="submit" type="submit" value="Submit">
  </form>
</div>
</body>
</html>