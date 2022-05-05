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
    <title>Mostra Tipo Struttura</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>Mostra Tipo Struttura</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Tipo Struttura</th>

    </tr>
    <c:forEach items="${tipostrutture}" var="tstr">
        <tr>
            <td>${tstr.id}</td>
            <td>${tstr.tipo}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
