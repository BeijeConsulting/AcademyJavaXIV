<%--
  Created by IntelliJ IDEA.
  User: giusepperaddato
  Date: 05/05/22
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Modifica tipo Struttura</title>
</head>
<body>

<h1>Modifica tipo Struttura</h1>

<form action="updateTipoStruttura" method="post">
    <label for="idtipo">Inserisci ID tipo Struttura:</label><br>
    <input type="text" id="idtipo" name="id_tipo" value=""><br>
    <label for="tipo">Inserisci tipo Struttura:</label><br>
    <input type="text" id="tipo" name="tipo" value=""><br>
    <input type="submit" value="Modifica">
</form>

<c:choose>
    <c:when test="${ risultato!=null and risultato==true}">Aggiornato con successo</c:when>
    <c:otherwise>Errore</c:otherwise>
</c:choose>

</body>
</html>
