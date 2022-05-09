<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stampa periodi prenotati</title>
</head>
<body>
<form action="inserisci-prenotazione">
	<input type="submit" class="order" value="Inserisci">
</form>
<c:choose>
	<c:when test="${empty periodiPrenotati}">NESSUN PERIODO PRENOTATO</c:when>
	<c:otherwise>
		<c:forEach items="${periodiPrenotati}" var="periodoPrenotato">
			<div>Pp: ${periodoPrenotato}
				<form action="modifica-prenotazioni">
					<input type="hidden" name="id" value="${periodoPrenotato.id}">
					<input type="submit" class="order" value="Modifica">
				</form>
				<form action="elimina-prenotazioni">
					<input type="hidden" name="id" value="${periodoPrenotato.id}">
					<input type="submit" class="order" value="Elimina">
				</form>
			</div>
		</c:forEach>
	</c:otherwise>
</c:choose>
</body>
</html>