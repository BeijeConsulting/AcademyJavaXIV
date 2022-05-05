<%--
  Created by IntelliJ IDEA.
  User: giusepperaddato
  Date: 05/05/22
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Mostra Struttura</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>Mostra Struttura</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Tipo Struttura</th>
        <th>descrizione</th>
        <th>indirizzo id</th>
        <th>utente id</th>

    </tr>
    <c:forEach items="${strutture}" var="str">
        <tr>
            <td>${str.id}</td>
            <td>${(str.tipologiaStrutturaId).tipo}</td>
            <td>${str.descrizione}</td>
            <td>
                    ${str.indirizzo.via}
                    ${str.indirizzo.numeroCivico}-
                    ${str.indirizzo.citta}
                    ${str.indirizzo.cap}
                    ${str.indirizzo.provincia}-
                    ${str.indirizzo.stato}
                    ${str.indirizzo.cap}
            </td>

            <td>${str.utente}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
