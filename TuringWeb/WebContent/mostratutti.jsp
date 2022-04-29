<%@ page import="it.beije.turing.web.db.Order" %><%--
  Created by IntelliJ IDEA.
  User: giusepperaddato
  Date: 28/04/22
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cerca</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<form method="get" action="showall">

    <h3>Scegli tipo di ordinamento</h3>

    <%  Order chose=(Order) session.getAttribute("order");
        session.removeAttribute("order");
        System.out.println(chose.toString());
    %>
    <div class="radio-toolbar">
        <div class="al">
        <input type="radio" name="ordina" id="nessuno" value="nessuno" <% if (chose==Order.NO){out.print("checked");}%> >
        <label for="nessuno">Nessuno</label>

        <input type="radio" name="ordina" id="nome" value="nome" <%if (chose==Order.NOME){out.print("checked");} %> >
        <label for="nome">Nome</label>

        <input type="radio" name="ordina" id="cognome" value="cognome" <%if (chose==Order.COGNOME){out.print("checked");} %> >
        <label for="cognome">Cognome</label>
        </div>
        <input type="submit" value="Ordina">
    </div>
</form>
    <iframe src="risultati.jsp" title="Risultati" width="100%" height="100%">
    </iframe>
</body>
</html>
