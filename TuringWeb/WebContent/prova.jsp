<%--
  Created by IntelliJ IDEA.
  User: 39346
  Date: 30/04/2022
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int x=3;
    System.out.println(x);
    out.println("valore di x: " + x);
    String nome= (String) session.getAttribute("fname");
    System.out.println("nella jsp:" + nome);

%>
</body>
</html>
