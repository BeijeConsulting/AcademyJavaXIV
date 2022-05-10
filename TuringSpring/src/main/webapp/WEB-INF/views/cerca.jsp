<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica | Beijebnb</title>
</head>
<body>

    <h1>Cerca per email</h1>

    <form action="./cerca" method="post">
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" placeholder="Inserisci email"><br><br>
        <input type="submit" value="CERCA">
    </form>

</body>
</html>