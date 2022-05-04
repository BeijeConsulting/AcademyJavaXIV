
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Contatto</title>
</head>
<body>
    <h3>
        Inserito nuovo contatto:
    </h3>
    <br>
    ${contatto}
    <br>
    <br>
    <br>
    <form action="./" method="GET">
        <input type="submit" name="submit" value="Back to home page">
    </form>
</body>
</html>