<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Contatto</title>
</head>
<body>

<form action="contatto" method="post">
    <label for="nome">Nome:</label><br>
    <input type="text" id="nome" name="nome" value=""><br>
    <label for="cognome">Cognome:</label><br>
    <input type="text" id="cognome" name="cognome" value=""><br>
    <label for="telefono">Telefono:</label><br>
    <input type="telefono" id="telefono" name="telefono" value=""><br>
    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" value=""><br>
    <label for="note">Note:</label><br>
    <input type=" note" id="note" name="note" value=""><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>