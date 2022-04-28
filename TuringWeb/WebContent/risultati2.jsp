<%@ page import="it.beije.turing.rubrica.Contatto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: giusepperaddato
  Date: 28/04/22
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        input[type=radio] {

            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #e3e3e3
        }

        th {
            background-color: #fa870b;
            color: white;
        }
    </style>
</head>
<body>


<%
    List<Contatto> risultati=(List<Contatto>)session.getAttribute("risultati");
%>

<h1>Totale Numeri: <%= risultati.size() %>
</h1>
<table style="width:100%">
    <tr>
        <th>Id</th>
        <th>Nome</th>
        <th>Cognome</th>
        <th>Telefono</th>
        <th>Email</th>
        <th>Note</th>
    </tr>


        <% for (Contatto c: risultati) {%>

    <tr>
        <td><%= c.getId() %>
        </td>
        <td><%= c.getNome() %>
        </td>
        <td><%= c.getCognome() %>
        </td>
        <td><%= c.getTelefono() %>
        </td>
        <td><%= c.getEmail() %>
        </td>
        <td><%= c.getNote() %>
        </td>
    </tr>
        <% }  %>

</body>
</html>
