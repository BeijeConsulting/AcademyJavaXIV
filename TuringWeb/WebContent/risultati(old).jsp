

<%@ page import="it.beije.turing.web.db.Order" %>
<%@ page import="it.beije.turing.web.db.Contatto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Risultati</title>

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

<jsp:useBean id="op" class="it.beije.turing.web.db.JPAManager"></jsp:useBean>

<%
    String s = request.getParameter("ordina");
    Order chose = Order.NO;
    if (s != null && !s.isEmpty())
        switch (s) {
            case "nessuno":
                chose = Order.NO;
                break;
            case "nome":
                chose = Order.NOME;
                break;
            case "cognome":
                chose = Order.COGNOME;
                break;
            default:
                chose = Order.NO;
                break;
        }
    List<Contatto> contattos = op.showContact(chose);

%>

<form method="get" action="risultati(old).jsp">

    <h3>Scegli tipo di ordinamento</h3>
    <input type="radio" name="ordina" id="nessuno" value="nessuno"
        <%
        if (chose==Order.NO){
            out.print("checked");
        }
        %>
    >
    <label for="nome">Nessuno</label><br>

    <input type="radio" name="ordina" id="nome" value="nome"
        <%if (chose==Order.NOME){
                out.print("checked");
            }
        %>
    >
    <label for="nome">Nome</label><br>

    <input type="radio" name="ordina" id="cognome" value="cognome"
        <%if (chose==Order.COGNOME){
             out.print("checked");
            }
        %>
    >
    <label for="nome">Cognome</label><br>

    <button type="submit">Invia</button>

</form>


<h1>Totale Numeri: <%= contattos.size() %>
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


        <% for (Contatto c: contattos) {%>

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
