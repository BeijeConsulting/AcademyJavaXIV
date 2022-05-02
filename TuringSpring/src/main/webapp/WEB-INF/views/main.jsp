<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>ID</th>
<th>Nome</th>
<th>Cognome</th>
<th>Email</th>
<th>Telefono</th>
</tr>
<c:forEach items="${contatti}" var="contatto">
<tr>
<td>${contatto.id}</td>
<td>${contatto.nome}</td>
<td>${contatto.cognome}</td>
<td>${contatto.email}</td>
<td>${contatto.telefono}</td>
</tr>
</c:forEach>
</table>


<form action="addContatto" method="post">
	<input type= "text" id="nome" name="nome" value="">
	<input type= "text" id="cognome" name="cognome" value="">
	<input type= "text" id="email" name="email" value="">
	<input type= "text" id="telefono" name="telefono" value="">
	<input type="submit" value="new">
	</form>
	
	<form action="update" method="post">
	<input type= "text" id="id" name="id" value="id">
	<input type= "text" id="nome" name="nome" value="">
	<input type= "text" id="cognome" name="cognome" value="">
	<input type= "text" id="email" name="email" value="">
	<input type= "text" id="telefono" name="telefono" value="">
	<input type="submit" value="update">
	</form>
	
	
	
	
	<form action="search" method="post">
	<input type= "text" id="id" name="id" value="id">
	<input type= "text" id="nome" name="nome" value="">
	<input type= "text" id="cognome" name="cognome" value="">
	<input type= "text" id="email" name="email" value="">
	<input type= "text" id="telefono" name="telefono" value="">
	<input type="submit" value="search">
	</form>
	
	<form action="delete" method="post">
	<input type= "text" id="id" name="id" value="id">
	<input type="submit" value="delete">
	</form>

	<form action="duplicates" method="get">
	<input type="submit" value="duplicates">
	</form>
	
	
	
	<form action="" method="get">
	<input type="submit" value="refresh">
	</form>



</body>
</html>