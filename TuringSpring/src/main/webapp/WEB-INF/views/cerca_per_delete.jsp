<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina | Beijebnb</title>
</head>
<body>

    <h1>Cerca per email</h1>

    <form action="./delete" method="post">
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" placeholder="Inserisci email"><br><br>
        <input type="submit" value="ELIMINA">
    </form>

</body>
</html>