<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Modifica url immagine</title>
</head>
<body>

<h1>Modifica immagini</h1>

<form action="updateImmagine" method="post">
    <label for="idImmagine">Inserisci ID Immagine:</label><br>
    <input type="text" id="idImmagine" name="idImmagine" value=""><br>
    <label for="urlImage">Inserisci url immagine:</label><br>
    <input type="text" id="urlImage" name="urlImage" value=""><br>
    <input type="submit" value="Modifica">
</form>

<c:choose>
    <c:when test="${ risultato!=null and risultato==true}">Aggiornato con successo</c:when>
    <c:otherwise>Errore</c:otherwise>
</c:choose>

</body>
</html>