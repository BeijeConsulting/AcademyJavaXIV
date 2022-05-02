
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Contatto</title>
</head>
<body>

<form action="insert_contatto" method="post">

  <label for="nome">Nome:</label><br>
  <input type="text" id="nome" name="nome"><br>
  
  <label for="cognome">Cognome:</label><br>
  <input type="text" id="cognome" name="cognome"><br>
  
  <label for="lname">email:</label><br>
  <input type="text" id="email" name="email"><br>
  
  <label for="lname">telefono:</label><br>
  <input type="text" id="telefono" name="telefono"><br>
  
  <label for="lname">note:</label><br>
  <input type="text" id="note" name="note"><br><br>

  <input type="submit" value="Submit">
  
</form> 

</body>
</html>