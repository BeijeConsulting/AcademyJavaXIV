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
    <title>Cancella Tipo Struttura</title>
</head>
<body>
<H1>Cancella Tipo Struttura</H1>
<form action="deleteTipoStruttura" method="post">
    <label for="tipo">Inserisci id del tipo Struttura da eliminare:</label><br>
    <input type="text" id="tipo" name="id_tipo" value=""><br>
    <input type="submit" value="Elimina">
</form>
<c:choose>
    <c:when test="${ risultato!=null and risultato==true}">Eliminato con successo</c:when>
    <c:otherwise>Errore</c:otherwise>
</c:choose>
</body>
</html>
