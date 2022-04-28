<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.util.MyJPAManager"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   <link rel="stylesheet" href="style.css">
   <title>Contatti</title>
</head>
<body>

   <%@ include file="header.jsp"%>

   <h1>Tutti i contatti</h1>

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
               <th scope="col">Azioni</th>
            </tr>
         </thead>
         <tbody>
            <% for (Contatto c : MyJPAManager.showContacts()) { %>
                <tr>
                    <th scope="row"><% out.print(c.getId()); %></th>
                    <td><% out.print(c.getNome()); %></td>
                    <td><% out.print(c.getCognome()); %></td>
                    <td><% out.print(c.getTelefono()); %></td>
                    <td><% out.print(c.getEmail()); %></td>
                    <td><% out.print(c.getNote()); %></td>
                    <td>
                        <button class="btn btn-success">MODIFICA</button>
                        <button class="btn btn-danger">ELIMINA</button>
                    </td>
                </tr>
            <% } %>

         </tbody>
      </table>
   </div>

</body>
</html>