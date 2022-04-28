<%@page import="it.beije.turing.JPAContactsManager.ContactDBManager"%>
<%@page import="it.beije.turing.JPAContactsManager.Contatto"%>
<%@page import="java.util.List"%>
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
.table { color: #fff
</style>
<title>Contatti</title>
</head>
<body>

<%String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		System.out.println(fname);
		System.out.println(lname);
		System.out.println(phone);
		System.out.println(email);

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
			List<Contatto> contactsFound = ContactDBManager.searchContacts(contact);

			if (contactsFound.size() == 0){
				response.sendRedirect("not_found.jsp");

			}else { %>

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



<%for (Contatto contatto : contactsFound) { %>
		<tr>
		<th scope="row"><%out.print(contatto.getId());%></th>
		<td> <%out.print(contatto.getNome());%></td>
		<td> <%out.print(contatto.getCognome());%></td>
		<td> <%out.print(contatto.getTelefono());%> </td>
		<td> <%out.print(contatto.getEmail()); %></td>
		<td> <%out.print(contatto.getNote()); %></td>
		</tr>
<%}%>
<%}%>
<%}%>
</tbody>
</table>
</div>
</body>
</html>