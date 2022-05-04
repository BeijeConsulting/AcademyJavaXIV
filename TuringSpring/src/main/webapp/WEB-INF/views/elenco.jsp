<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RUBRICA</title>
</head>
<body>
<c:if test="${empty contatti}">NESSUN CONTATTO</c:if>
<%-- c:choose>
	<c:when test="${empty contatto}">NESSUN CONTATTO</c:when>
	<c:otherwise>${contatto.nome}&nbsp;${contatto.cognome}</c:otherwise>
</c:choose --%>

<c:forEach items="${contatti}" var="contatto">
ID: ${contatto.id}<br/>
NOME: ${contatto.nome}<br/>
COGNOME: ${contatto.cognome}<br/>

<c:forEach items="${contatto.riferimenti}" var="riferimenti">
RIF: ${riferimenti.riferimento} (${riferimenti.tipoRiferimento} ${riferimenti.tipologia})<br/>
</c:forEach>
NOTE: ${contatto.note}<br/><br/>
</c:forEach><br/>
<%-- TELEFONO: ${contatto.telefono}<br/>
EMAIL: ${contatto.email}<br/>--%
</c:forEach> --%>




</body>
</html>