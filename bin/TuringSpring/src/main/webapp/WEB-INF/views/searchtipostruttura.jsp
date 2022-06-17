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
    <title>Cerca tipo Struttura</title>

    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<h1>Cerca tipo Struttura</h1>

<form action="searchTipoStruttura" method="post">
    <label for="tipo">Inserisci tipo Struttura:</label><br>
    <input type="text" id="tipo" name="tipo" value=""><br>
    <input type="submit" value="Cerca">
</form>

<c:choose>
    <c:when test="${ lista!=null}">

        <h3>Strutture Trovate ${lista.size()}</h3>
        <table>
            <tr>
                <th>Id</th>
                <th>Tipo Struttura</th>

            </tr>
            <c:forEach items="${lista}" var="lista">
                <tr>
                    <td>${lista.id}</td>
                    <td>${lista.tipo}</td>
                </tr>
            </c:forEach>
        </table>


    </c:when>
    <c:otherwise>Errore</c:otherwise>
</c:choose>

</body>
</html>
