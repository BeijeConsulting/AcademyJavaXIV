<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rubrica Pagani</title>
</head>
<body>

<h1>RUBRICA</h1>

<label for="contacts">Contatti:</label>
<br>
<textarea id="contacts" name="contacts" rows="10" cols="100" readonly>
<c:if test="${empty contatti}">Nessun Contatto</c:if>
<c:forEach items="${contatti}" var="contatto">
ID: ${contatto.id}
NOME: ${contatto.nome}
COGNOME: ${contatto.cognome}
EMAIL: ${contatto.email}
TELEFONO: ${contatto.telefono}
NOTE: ${contatto.note}
</c:forEach>
</textarea>
<br><br>

<form action="getRubrica" id="getRubrica" method="post">
<input type="hidden" name="post" value="getRubrica"/>
  <h3 style="display:inline-block;">Mostra Rubrica:</h3>
  <input type="submit">
</form>
<br>


<form action="findDuplicates" id="findDuplicates" method="post">
<input type="hidden" name="post" value="findDuplicates"/>
  <h3 style="display:inline-block;">Trova Contatti Duplicati:</h3>
  <input type="submit">
</form>
<br>

<form action="uniteDuplicates" id="uniteDuplicates" method="post">
<input type="hidden" name="post" value="uniteDuplicates"/>
  <h3 style="display:inline-block;">Unisci Contatti Duplicati:</h3>
  <input type="submit">
</form>
<br>

<form action="findContact" id="findContact" method="post">
<input type="hidden" name="post" value="findContact"/>
  <h3>Trova contatto (filtro):</h3> <input type="text" name="filtro" placeholder="filtro">
  <input type="submit">
</form>
<br>

<form action="modifyContact" id="modifyContact" method="post">
<h3>Modifica Contatto:</h3>
<input type="hidden" name="post" value="modifyContact"/>
	<table>
  		<tr>
			<td align="right">Indice Contatto:</td>
			<td align="left"><input type="text" name="indice" /></td>
		</tr>
		<tr>
			<td align="right">Nome:</td>
			<td align="left"><input type="text" name="nome" /></td>
		</tr>
		<tr>
			<td align="right">Cognome:</td>
			<td align="left"><input type="text" name="cognome" /></td>
		</tr>
		<tr>
			<td align="right">Email:</td>
			<td align="left"><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td align="right">Telefono:</td>
			<td align="left"><input type="text" name="telefono" /></td>
		</tr>
		<tr>
			<td align="right">Note:</td>
			<td align="left"><input type="text" name="note" /></td>
		</tr>
		<tr>
			<td align="right"><input type="submit"/></td>
		</tr>
	</table>
</form>
<br>

<form action="deleteContact" id="deleteContact" method="post">
<input type="hidden" name="post" value="deleteContact"/>
  <h3>Elimina Contatto (indice):</h3> <input type="text" name="indice" placeholder="indice">
  <input type="submit">
</form>
<br>

<form action="addContact" id="addContact" method="post">
<h3>Crea Contatto:</h3>
<input type="hidden" name="post" value="addContact"/>
	<table>
		<tr>
			<td align="right">Nome:</td>
			<td align="left"><input type="text" name="nome" /></td>
		</tr>
		<tr>
			<td align="right">Cognome:</td>
			<td align="left"><input type="text" name="cognome" /></td>
		</tr>
		<tr>
			<td align="right">Email:</td>
			<td align="left"><input type="text" name="email" /></td>
		</tr>
		<tr>
			<td align="right">Telefono:</td>
			<td align="left"><input type="text" name="telefono" /></td>
		</tr>
		<tr>
			<td align="right">Note:</td>
			<td align="left"><input type="text" name="note" /></td>
		</tr>
		<tr>
			<td align="right"><input type="submit"/></td>
		</tr>
	</table>
</form>

</body>
</html>