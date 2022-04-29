<%@ page import="it.beije.turing.web.db.Contatto" %><%--
  Created by IntelliJ IDEA.
  User: giusepperaddato
  Date: 28/04/22
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifica</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    Contatto contatto= (Contatto) session.getAttribute("contatto");
%>
<form action="./searchsingle?type=edit"  method="post">
    <label for="Nome"><b>Inserisci ID del contatto da modificare</b></label>
    <input type="text" id="nome" name="idPar" placeholder="Inserisci ID">
    <input type="submit" value="Cerca">
</form>
<%

    if(contatto!=null){

        out.println("<iframe src=\"form.jsp?type=edit\" title=\"Risultati\" width=\"100%\" height=\"100%\"> </iframe>");
    }else{
        out.print("Contatto non trovalo");
    }
%>

</body>
</html>
