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
COGNOME: ${contatto.cognome}<br/>
NOME: ${contatto.nome}<br/>
TELEFONO: ${contatto.telefono}<br/>
</c:forEach>




</body>
</html>