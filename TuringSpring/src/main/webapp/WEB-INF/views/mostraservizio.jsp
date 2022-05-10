<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostra servizio</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Servizio nome</th>
        <th>Url img</th>
    </tr>
    <c:forEach items="${servizi}" var="ser">
        <tr>
            <td>${ser.id}</td>
            <td>${ser.nome}</td>
            <td>${ser.urlImg}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>