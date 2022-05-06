<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INDEX TURING SPRING</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }

    </style>
</head>
<body>
<table width="100%">


    <tr>
        <th colspan="2"><h3>Tipo Struttura</h3></th>
    </tr>
    <tr>
        <th>Operation</th>
        <th>URL</th>
    </tr>
    <tr>
        <td>Mostra tutti tipi strutture</td>
        <td><a href="http://localhost:8080/TuringSpring/showAllTipoStruttura">/showAllTipoStruttura</a></td>
    </tr>
    <tr>
        <td>Inserimento nuovo  tipi strutture</td>
        <td><a href="http://localhost:8080/TuringSpring/insertTipoStruttura">/insertTipoStruttura</a></td>
    </tr>
    <tr>
        <td>Cancella  tipi strutture</td>
        <td><a href="http://localhost:8080/TuringSpring/deleteTipoStruttura">/deleteTipoStruttura</a></td>
    </tr>
    <tr>
        <td>Aggiorna  tipo strutture</td>
        <td><a href="http://localhost:8080/TuringSpring/updateTipoStruttura">/updateTipoStruttura</a></td>
    </tr>
    <tr>
        <td>Trova  tipo strutture</td>
        <td><a href="http://localhost:8080/TuringSpring/searchTipoStruttura">/searchTipoStruttura</a></td>
    </tr>


    <tr>
        <th colspan="2"><H3>Struttura</H3></th>
    </tr>
    <tr>
        <th>Operation</th>
        <th>URL</th>
    </tr>
    <tr>
        <td>Mostra tutte strutture</td>
        <td><a href="http://localhost:8080/TuringSpring/showAllStrutture">/showAllStrutture</a></td>
    </tr>
    <tr>
        <td>Cancella struttura</td>
        <td><a href="http://localhost:8080/TuringSpring/deleteStruttura">/deleteStruttura</a></td>
    </tr>


    <tr>
        <td>Inserisci struttura</td>
        <td><a href="http://localhost:8080/TuringSpring/insertStruttura">/insertStruttura</a></td>
    </tr>

</table>
</body>
</html>