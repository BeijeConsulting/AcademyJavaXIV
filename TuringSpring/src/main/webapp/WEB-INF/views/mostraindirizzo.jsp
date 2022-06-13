<%--
  Created by IntelliJ IDEA.
  User: simonepitossi
  Date: 06/05/22
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Mostra Indirizzo</title>
  <style>
    table, th, td {
      border: 1px solid black;
    }
  </style>
</head>
<body>
<h1>Mostra Indirizzo</h1>
<table>
  <tr>
    <th>Id</th>
    <th>Indirizzo</th>

  </tr>
  <c:forEach items="${indirizzi}" var="ind">
    <tr>
      <td>${ind.id}</td>
      <td>${ind.cap}</td>
      <td>${ind.citta}</td>
      <td>${ind.provincia}</td>
      <td>${ind.via}</td>
      <td>${ind.stato}</td>
      <td>${ind.numeroCivico}</td>
      <td>${ind.coordinate}</td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
