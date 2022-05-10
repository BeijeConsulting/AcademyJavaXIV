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
        <th>url_image</th>


    </tr>
    <c:forEach items="${immagini}" var="imm">
        <tr>
            <td>${imm.id}</td>
            <td>${imm.url_image}</td>
            <td>${str.utente}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
