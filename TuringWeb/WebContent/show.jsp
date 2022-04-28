
import it.beije.turing.JPAContactsManager.ContactDBManager;
import it.beije.turing.JPAContactsManager.Contatto;
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
     <head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style>
body {
background-color: #23272e;
color: white;

.table { color: #fff
}
</style>
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
  <% for (Contatto contatto : ContactDBManager.ShowContacts()) { %>
  <tr>
       <th scope="row"><% contatto.getId()%></th>
         <td><% contatto.getNome()%></td>
       <td><% contatto.getCognome()%> </td>
          <td><% contatto.getTelefono()%></td>
                 <td><% contatto.getEmail()%></td>
               <td><% contatto.getNote()%></td>
              </tr>
         <%  }%>
</tbody>
</table>
</body>
</html>