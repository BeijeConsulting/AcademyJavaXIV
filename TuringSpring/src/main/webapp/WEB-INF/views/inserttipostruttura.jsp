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
    <title>Inserisci tipo Struttura</title>
</head>
<body>
<h1>Inserisci tipo Struttura</h1>
<form action="insertTipoStruttura" method="post">
    <label for="tipo">Inserisci tipo Struttura:</label><br>
    <input type="text" id="tipo" name="tipo" value=""><br>
    <input type="submit" value="Salva">
</form>


<c:choose>
    <c:when test="${ risultato!=null and risultato==true}">Aggiunto</c:when>
    <c:otherwise>Non Aggiunto</c:otherwise>
</c:choose>
</body>
</html>
