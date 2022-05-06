<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Modifica url immagine</title>
</head>
<body>

<h1>Modifica immagini</h1>

<form action="updateStrutturaImmagine" method="post">
    <label for="idStrutturaImmagine">Inserisci ID Immagine:</label><br>
    <input type="text" id="idStrutturaImmagine" name="idStrutturaImmagine" value=""><br>
    <label for="strutturaId">Inserisci id struttura:</label><br>
    <input type="text" id="strutturaId" name="strutturaId" value=""><br>
    <label for="immagineId">Inserisci id struttura:</label><br>
    <input type="text" id="immagineId" name="immagineId" value=""><br>
    <input type="submit" value="Modifica">
</form>

<c:choose>
    <c:when test="${ risultato!=null and risultato==true}">Aggiornato con successo</c:when>
    <c:otherwise>Errore</c:otherwise>
</c:choose>

</body>
</html>