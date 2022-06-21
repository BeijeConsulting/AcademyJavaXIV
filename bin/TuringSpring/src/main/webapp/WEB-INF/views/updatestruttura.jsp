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
    <title>Modifica Struttura</title>
</head>
<body>

<h1>Modifica Struttura</h1>

<form action="loadStruttura" method="post">

    <select name="id_struttura" id="id_struttura">
        <c:forEach items="${lista_strutture}" var="lista_strutture">
            <option value="${lista_strutture.id}">${lista_strutture}</option>
        </c:forEach>
    </select>
    <br>
    <input type="submit" value="Modifica">
</form>


<form action="updateStruttura" method="post">
    <label for="descrizione">Inserisci descrizione Struttura:</label><br>
    <input type="text" id="descrizione" name="descrizione" value="${struttura.descrizione}"><br>
    <input type="text" name="id_struttura" value="${struttura.id}" hidden><br>
    <label for="tipo-strutture">Tipo di struttura disponibile: </label><br>
    <select name="tipo-strutture" id="tipo-strutture">
        <c:forEach items="${listatipostruttura}" var="tstr" >
            <option
                    <c:choose>
                        <c:when test="${ struttura.tipologiaStrutturaId.id==tstr.id}"> selected </c:when>
                    </c:choose>
                    value="${tstr.id}">${tstr.tipo}</option>
        </c:forEach>
    </select>
    <br>
    <label for="lista_indirizzio">Scegli indirizzo:</label><br>
    <select name="lista_indirizzio" id="lista_indirizzio">
        <c:forEach items="${lista_indirizzio_u}" var="l_indirizzo">
            <option
                    <c:choose>
                        <c:when test="${ struttura.indirizzo.id==l_indirizzo.id}"> selected </c:when>
                    </c:choose>
                    value="${l_indirizzo.id}">${l_indirizzo.toString()}</option>
        </c:forEach>
    </select>
    <br>
    <label for="id_utente">Inserisci ID Utente:</label><br>
    <input type="text" id="id_utente" name="id_utente" value="${struttura.utente.id}"><br>

    <br>
    <input type="submit" value="Salva">
</form>

</body>
</html>
