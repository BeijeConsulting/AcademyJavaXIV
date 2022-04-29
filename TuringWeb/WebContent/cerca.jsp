<%--
  Created by IntelliJ IDEA.
  User: giusepperaddato
  Date: 28/04/22
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cerca</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<form action="./cerca"  method="post">
    <label for="Nome"><b>Immettere Parola da ricercare</b></label>
    <input type="text" id="nome" name="parameter" placeholder="Inserisci parola">
    <input type="submit" value="Cerca">
</form>
    <iframe src="risultati.jsp" title="Risultati" width="100%" height="100%">
    </iframe>
</body>
</html>
