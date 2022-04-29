<%@page import="main.java.it.beije.turing.JPAContactsManager.ContactDBManager" %>
<%@page import="main.java.it.beije.turing.JPAContactsManager.Contatto" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        body {
            background-color: #23272e;
            color: white;
        }

        .table {
            color: #fff;
        }

        .container {
            padding: 30px 0;
            width: 80%;
            min-width: 300px;
            margin: 0 auto;
            display: flex;
            justify-content: center;
        }
    </style>
    <title>Contatti</title>
</head>
<body>
<%@ include file="header.jsp" %>
<table class="table">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Nome</th>
        <th scope="col">Cognome</th>
        <th scope="col">Telefono</th>
        <th scope="col">Email</th>
        <th scope="col">Note</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="contatto" type="java.util.List" scope="session"></jsp:useBean>
    <% for (Contatto contatto1 : (List<Contatto>) contatto) { %>
    <tr>
        <th scope="row"><%=contatto1.getId()%>
        </th>
        <td><%=contatto1.getNome()%>
        </td>
        <td><%=contatto1.getCognome()%>
        </td>
        <td><%=contatto1.getTelefono()%>
        </td>
        <td><%=contatto1.getEmail()%>
        </td>
        <td><%=contatto1.getNote()%>
        </td>
        <td>
            <form class="d-inline-block" action="edit_contact.jsp">
                <input type="hidden" name="id" value="<%= contatto1.getId() %>">
                <input type="hidden" name="fname" value="<%= contatto1.getNome() %>">
                <input type="hidden" name="lname" value="<%= contatto1.getCognome() %>">
                <input type="hidden" name="phone" value="<%= contatto1.getTelefono() %>">
                <input type="hidden" name="email" value="<%= contatto1.getEmail() %>">
                <input type="hidden" name="notes" value="<%= contatto1.getNote() %>">
                <input class="btn btn-success" type="submit" value="MODIFICA">
            </form>
            <form class="d-inline-block" action="./delete_contact.jsp">
                <input type="hidden" name="id" value="<%= contatto1.getId() %>">
                <input type="hidden" name="fname" value="<%= contatto1.getNome() %>">
                <input type="hidden" name="lname" value="<%= contatto1.getCognome() %>">
                <input type="hidden" name="phone" value="<%= contatto1.getTelefono() %>">
                <input type="hidden" name="email" value="<%= contatto1.getEmail() %>">
                <input type="hidden" name="notes" value="<%= contatto1.getNote() %>">
                <input class="btn btn-danger" type="submit" value="ELIMINA">
            </form>
        </td>
    </tr>
    <% }%>
    </tbody>
</table>
</body>
</html>