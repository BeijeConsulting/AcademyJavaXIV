<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="style.css">
  <title>Cerca in Rubrica | Java</title>
</head>
<body>

<%@ include file="header.jsp"%>

<h1>Cerca in rubrica</h1>

<h2>Dati contatto</h2>
<div class="container">
  <form action="./search_result">
    <label for="fname">Nome:</label>
    <input type="text" id="fname" name="fname">
    <label for="lname">Cognome:</label>
    <input type="text" id="lname" name="lname">
    <label for="phone">Telefono:</label>
    <input type="text" id="phone" name="phone">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email">
    <input class="submit" type="submit" value="Submit">
  </form>
</div>
</body>
</html>