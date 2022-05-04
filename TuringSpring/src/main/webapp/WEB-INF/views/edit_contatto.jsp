
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%--
  Created by IntelliJ IDEA.
  User: Padawan
  Date: 02-May-22
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifica contatti</title>
</head>
<body>
<c:forEach items="${contatti}" var="c">
     <form action="./editor" method="POST">
             ${c}
         <input type="hidden" name="contactId" value=${c.id}>
         <input type="submit" name="submit" value="Delete">
    </form>
    <form action="./" method="GET">
    <input type="submit" name="submit" value="Edit">
</form>
    <br>
</c:forEach>
<br>
<form action="./" method="GET">
    <br>
    <input type="submit" name="submit" value="Back to home page">
</form>
</body>
</html>