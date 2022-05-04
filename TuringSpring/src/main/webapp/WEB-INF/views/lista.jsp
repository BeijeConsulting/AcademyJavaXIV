<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even){background-color: #f2f2f2;}

        #customers tr:hover {background-color: #ddd;}

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #fa9111;
            color: white;
        }
    </style>
</head>
<body>

<h1>Lista elementi</h1>

<c:choose>
	<c:when test="${empty list}">NESSUN CONTATTO</c:when>
	<c:otherwise>

        <h3>Lista elementi: ${list.size()+""}</h3>

        <table id="customers" >
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>email</th>
                <th>telefono</th>
                <th>note</th>
            </tr>
        <c:forEach items="${list}" var="cont">
            <tr>
                <td>${cont.id}</td>
                <td>${cont.nome}</td>
                <td>${cont.cognome}</td>
                <td>${cont.email}</td>
                <td>${cont.telefono}</td>
                <td>${cont.note}</td>
            </tr>
        </c:forEach>
        </table>
    </c:otherwise>
</c:choose >
</body>
</html>
