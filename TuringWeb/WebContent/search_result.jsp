<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="it.beije.turing.web.rubrica.Contatto"%>
<%@page import="it.beije.turing.web.util.MyJPAManager"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   <link rel="stylesheet" href="style.css">
   <title>Contatti Trovati</title>
</head>
<body>

   <%
   String fname = request.getParameter("fname");
   String lname = request.getParameter("lname");
   String phone = request.getParameter("phone");
   String email = request.getParameter("email");

   Contatto contact = new Contatto();
   if (!fname.equals("")) contact.setNome(fname);
   if (!lname.equals("")) contact.setCognome(lname);
   if (!phone.equals("")) contact.setTelefono(phone);
   if (!email.equals("")) contact.setEmail(email);

   if ((contact.getNome() == null) &&
      (contact.getCognome() == null) &&
      (contact.getTelefono() == null) &&
      (contact.getEmail() == null)
   ) response.sendRedirect("invalid_form.jsp");
   else {
               List<Contatto> contactsFound = MyJPAManager.searchContacts(contact);

               if (contactsFound.size() == 0){
                   response.sendRedirect("not_found.jsp");

               }else {%>

   <%@ include file="header.jsp"%>

      <h1>Contatti trovati</h1>

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
               <% for (Contatto c : contactsFound) { %>
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

   <%            }
           }%>




</body>
</html>