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

    <form action="./register" method="post">
        <label for="fname">First name:</label><br>
        <input type="text" id="fname" name="fname" placeholder="Inserisci nome"><br>
        <label for="lname">Last name:</label><br>
        <input type="text" id="lname" name="lname" placeholder="Inserisci nome"><br><br>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" placeholder="Inserisci email"><br><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" placeholder="Inserisci password"><br><br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>