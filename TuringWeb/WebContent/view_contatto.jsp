<%@ page import="it.beije.turing.web.Contatto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Padawan
  Date: 02-May-22
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% for (Contatto c : (List<Contatto>)request.getAttribute("contatti")){
    out.println(c.toString());%>
<br>
<%
}%>
</body>
</html>
