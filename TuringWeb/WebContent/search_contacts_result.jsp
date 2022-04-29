<%@page import="main.java.it.beije.turing.JPAContactsManager.ContactDBManager" %>
<%@page import="main.java.it.beije.turing.JPAContactsManager.Contatto" %>
<%@page import="java.util.List" %>
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
            min-height: 100vh;
        }

        .container {
            padding: 30px 0;
            width: 80%;
            min-width: 300px;
            margin: 0 auto;
            display: flex;
            justify-content: center;
        }

        .table {
            color: #fff;
        }
    </style>
    <title>Contatti</title>
</head>
<body>
<%@ include file="header.jsp" %>

<h1 class="text-center">Contatti corrispondenti trovati</h1>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nome</th>
            <th scope="col">Cognome</th>
            <th scope="col">Telefono</th>
            <th scope="col">Email</th>
            <th scope="col">Note</th>
        </tr>
        </thead>
        <tbody>

        <jsp:useBean id="contactsFound" type="java.util.List" scope="session"></jsp:useBean>
        <%for (Contatto contatto : (List<Contatto>) contactsFound) { %>
        <tr>
            <th scope="row"><%=contatto.getId()%>
            </th>
            <td><%=contatto.getNome()%>
            </td>
            <td><%=contatto.getCognome()%>
            </td>
            <td><%=contatto.getTelefono()%>
            </td>
            <td><%=contatto.getEmail()%>
            </td>
            <td><%=contatto.getNote() %>
            </td>
            <td>
            <form class="d-inline-block" action="edit_contact.jsp">
                <input type="hidden" name="id" value="<%= contatto.getId() %>">
                <input type="hidden" name="fname" value="<%= contatto.getNome() %>">
                <input type="hidden" name="lname" value="<%= contatto.getCognome() %>">
                <input type="hidden" name="phone" value="<%= contatto.getTelefono() %>">
                <input type="hidden" name="email" value="<%= contatto.getEmail() %>">
                <input type="hidden" name="notes" value="<%= contatto.getNote() %>">
                <input class="btn btn-success" type="submit" value="MODIFICA">
            </form>
            <form class="d-inline-block" action="./delete_contact.jsp">
                <input type="hidden" name="id" value="<%= contatto.getId() %>">
                <input type="hidden" name="fname" value="<%= contatto.getNome() %>">
                <input type="hidden" name="lname" value="<%= contatto.getCognome() %>">
                <input type="hidden" name="phone" value="<%= contatto.getTelefono() %>">
                <input type="hidden" name="email" value="<%= contatto.getEmail() %>">
                <input type="hidden" name="notes" value="<%= contatto.getNote() %>">
                <input class="btn btn-danger" type="submit" value="ELIMINA">
            </form>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>