
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
    <title>Vista contatti</title>
</head>
<body>
    <c:forEach items="${contatti}" var="c">
        ${c}
        <br>
    </c:forEach>
    <br>
    <form action="./" method="GET">
        <br>
        <input type="submit" name="submit" value="Back to home page">
    </form>
</body>
</html>
