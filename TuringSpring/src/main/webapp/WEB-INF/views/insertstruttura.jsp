<%--
  Created by IntelliJ IDEA.
  User: giusepperaddato
  Date: 05/05/22
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Inserisci  Struttura</title>

</head>
<body>
<h1>Inserisci  Struttura</h1>

<form action="insertStruttura" method="post">
    <label for="descrizione">Inserisci descrizione Struttura:</label><br>
    <input type="text" id="descrizione" name="descrizione" value=""><br>

    <label for="tipo-strutture">Tipo di struttura disponibile: </label><br>
    <select name="tipo-strutture" id="tipo-strutture">
        <c:forEach items="${listatipostruttura}" var="tstr">
                <option value="${tstr.id}">${tstr.tipo}</option>
        </c:forEach>
    </select>
    <br>
    <label for="id_indirizzo">Inserisci ID indirizzo:</label><br>
    <input type="text" id="id_indirizzo" name="id_indirizzo" value=""><br>

    <label for="id_utente">Inserisci ID Utente:</label><br>
    <input type="text" id="id_utente" name="id_utente" value=""><br>

    <br>
    <input type="submit" value="Salva">
</form>
</body>
</html>
