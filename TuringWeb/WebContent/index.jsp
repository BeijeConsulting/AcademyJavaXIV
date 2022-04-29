<%@page import="it.beije.turing.web.Contatto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rubrica Pagani</title>
</head>
<body>

<h1>HOMEPAGE RUBRICA</h1>

<label for="contacts">Contatti:</label>
<br>
<textarea id="contacts" name="contacts" rows="10" cols="100" readonly>
<%
List<Contatto> contatti = (List<Contatto>)session.getAttribute("contatti");

if (contatti == null) contatti = new ArrayList<>();

for (Contatto c : contatti)
{
	%><%= c + "\n"%><%
}
%>
</textarea>
<br><br>

<div style="float:left;clear:both;display: flex;">
<form action="./util" id="getRubrica" method="post">
<input type="hidden" name="post" value="getRubrica"/>
  <h3 style="display:inline-block;">Mostra Rubrica:</h3>
  <input type="submit">
</form>
</div>
<br>


<div style="float:left;clear:both;display: flex;">
<form action="./util" id="findDuplicates" method="post">
<input type="hidden" name="post" value="findDuplicates"/>
  <h3 style="display:inline-block;">Trova Contatti Duplicati:</h3>
  <input type="submit">
</form>
</div>
<br>

<div style="float:left;clear:both;display: flex;">
<form action="./util" id="uniteDuplicates" method="post">
<input type="hidden" name="post" value="uniteDuplicates"/>
  <h3 style="display:inline-block;">Unisci Contatti Duplicati:</h3>
  <input type="submit">
</form>
</div>
<br>

<div style="float:left;clear:both;display: flex;">
<form action="./util" id="findContact" method="post">
<input type="hidden" name="post" value="findContact"/>
  <h3>Trova contatto (filtro):</h3> <input type="text" name="filtro" placeholder="filtro">
  <input type="submit">
</form>
</div>
<br>

<div style="float:left;clear:both;display: flex;">
<form action="./util" id="modifyContact" method="post">
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
</div>
<br>

<div style="float:left;clear:both;display: flex;">
<form action="./util" id="deleteContact" method="post">
<input type="hidden" name="post" value="deleteContact"/>
  <h3>Elimina Contatto (indice):</h3> <input type="text" name="indice" placeholder="indice">
  <input type="submit">
</form>
</div>
<br>

<div style="float:left;clear:both;display: flex;">
<form action="./util" id="addContact" method="post">
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
</div>

</body>
</html>