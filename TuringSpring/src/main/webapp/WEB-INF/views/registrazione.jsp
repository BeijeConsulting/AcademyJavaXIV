<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione | Beijebnb</title>
</head>
<body>

    <form action="/action_page.php" method="post">
        <label for="fname">First name:</label><br>
        <input type="text" id="fname" name="fname" placeholder="Inserisci nome"><br>
        <label for="lname">Last name:</label><br>
        <input type="text" id="lname" name="lname" placeholder="Inserisci nome"><br><br>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" placeholder="Inserisci email"><br><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" placeholder="Inserisci password"><br><br>
        <label for="date">Data nascita:</label><br>
        <input type="date" id="date" name="date"><br><br>
        <label for="cod_documenti">Codice documento:</label><br>
        <input type="cod_documenti" id="cod_documenti" name="cod_documenti" placeholder="Inserisci codice documento"><br><br>
        <label for="telefono">Telefono:</label><br>
        <input type="text" id="telefono" name="telefono" placeholder="Inserisci codice documento"><br><br>
        <input type="text" value="Submit">
    </form>

</body>
</html>