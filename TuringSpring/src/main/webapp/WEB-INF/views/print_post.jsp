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

<c:forEach items="${contatti}" var="contatto">
${contatto.toString()}<br/>
</c:forEach>

<form action="./" method="get">
 		<label for="merge">Torna alla Home:     </label>
  		<input type="submit" id="merge" name="type" value="Submit"><br>
</form>

</body>
</html>