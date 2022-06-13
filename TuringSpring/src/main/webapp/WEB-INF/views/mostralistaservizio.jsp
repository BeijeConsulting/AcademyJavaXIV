<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>mostra lista servizio</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Struttura id</th>
        <th>Servizio id</th>
    </tr>
    <c:forEach items="${listaservizi}" var="listser">
        <tr>
        	<td>${listser.id}</td>
            <td>${listser.strutturaId}</td>
            <td>${listser.servizioId}</td>
   
        </tr>
    </c:forEach>
</table>
</body>
</html>