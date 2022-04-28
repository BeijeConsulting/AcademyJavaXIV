<%@page import="it.beije.turing.web.rubrica.JPACriteriaManager"%>
<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <style>
    * {
      padding: 0;
      margin: 0;
      box-sizing: border-box;
    }
    body {
      font-family: Helvetica, Times New Roman;
      background-color: mediumpurple;
      color: black;
      min-height: 100vh;
    }
    a {
      text-decoration: none;
      color: #fff;
    }
    a:hover {
      text-decoration: none;
    }
    h1 {
      text-align: center;
      padding: 30px 0;
    }
    .container {
      padding: 30px 0;
      width: 80%;
      min-width: 300px;
      margin: 0 auto;
      display: flex;
      justify-content: center;
    }
    h2 {
      margin-top: 30px;
      text-align: center;
    }
    form {
      width: 300px;
    }
    input {
      display: block;
      padding: 7px;
      width: 100%;
      margin: 5px 0;
      font-size: 17px;
      border: none;
      border-radius: 5px;
    }
    input:focus {
      outline: none;
    }
    label {
      display: block;
      margin-top: 18px;

    }
  </style>

  <%--  <style>--%>
<%--    * {--%>
<%--      padding: 0;--%>
<%--      margin: 0;--%>
<%--      box-sizing: border-box;--%>
<%--    }--%>
<%--    body {--%>
<%--      font-family: Helvetica, sans-serif;--%>
<%--      background-color: #23272e;--%>
<%--      color: black;--%>
<%--    }--%>
<%--    body {--%>
<%--      font-family: Helvetica, "Times New Roman";--%>
<%--      background-color: dodgerblue;--%>
<%--      color: black;--%>
<%--    }--%>
<%--    a {--%>
<%--      text-decoration: chartreuse;--%>
<%--      color: red;--%>
<%--    }--%>
<%--    a:hover {--%>
<%--      text-decoration: none;--%>
<%--    }--%>
<%--    h1 {--%>
<%--      text-align: center;--%>
<%--      padding: 30px 0;--%>
<%--    }--%>

<%--  </style>--%>
  <title>Contatti</title>
</head>
<body>
<table class=table>
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
<%--  <%PrintWriter out = new PrintWriter (response.getOutputStream ());%>--%>
  <% for (Contatto contatto : JPACriteriaManager.getRubrica()) { %>
  <tr>
    <th scope="row"><% out.print(contatto.getId());%></th>
    <td><% out.print(contatto.getNome());%></td>
    <td><% out.print(contatto.getCognome());%> </td>
    <td><% out.print(contatto.getTelefono());%></td>
    <td><% out.print(contatto.getEmail());%></td>
    <td><% out.print(contatto.getNote());%></td>
  </tr>
  <%  }%>


  </tbody>
</table>
<form action="../TuringWeb" method="post">
  <input type="submit" value="Torna indietro">
</form>

</body>
</html>