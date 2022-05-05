<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<table>
    <tr>
        <th>Id</th>
        <th>Struttura id</th>
        <th>Immagine id</th>

    </tr>
    <c:forEach items="${struttura_immagini}" var="str_imm">
        <tr>
            <td>${str_imm.id}</td>
            <td>${(str.tipologiaStrutturaId).tipo}</td>
            <td>${(str.immagineId).url_image}</td>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
