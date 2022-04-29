
<%@ page import="java.util.List" %>
<%@ page import="it.beije.turing.web.db.Contatto" %>
<%--
  Created by IntelliJ IDEA.
  User: giusepperaddato
  Date: 28/04/22
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="css/style.css">
  <title>Result</title>

</head>
<body>


<%
  List<Contatto> risultati=(List<Contatto>)session.getAttribute("risultati");
  String search=(String) session.getAttribute("search");

%>

<h1> <%

  if(search!=null){
      out.print("La parola cercata è: "+search+"<br>");
      session.removeAttribute("search");}
  if(risultati!=null){ out.print("Totale Numeri: "+risultati.size()); %>


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



      <%


      for (Contatto c: risultati) {%>

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
      <% }
        session.removeAttribute("risultati");
  }%>

</body>
</html>
