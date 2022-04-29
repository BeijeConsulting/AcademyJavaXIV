<%@ page import="it.beije.turing.web.db.Contatto" %>
<!DOCTYPE html>
<html>

    <link rel="stylesheet" href="css/style.css">

<body>

<%
    String type= (String) request.getParameter("type");
    if (type==null){
        type="";
    }

%>


    <div>
        <%
            String call="";
            if(type.equals("delete")) {
                call="\"./delete\"";
                out.print("<h3>Vuoi eliminare il Contatto</h3>");
            }
            if(type.equals("insert")) {
                call="\"./insert\"";
                out.print("<h3>Inserisi Contatto</h3>");
            }
            if(type.equals("edit")) {
                call="\"./edit\"";

                out.print("<h3>Modifica Contatto</h3>");
            }
            System.out.println(call);

            Contatto c= (Contatto) session.getAttribute("contatto");
            session.removeAttribute("contatto");


        %>

        <form action=<%=call%>  method="post">

            <% if(c!=null){

                out.println("<input type='hidden'  name='ID' value="+c.getId()+">");
            }%>


            <label for="Nome">Nome</label>
            <input type="text" id="nome" name="nome" placeholder="Inserisci nome" <% if(type.equals("delete")) out.println("disabled");
                if(c!=null) out.println("value="+ c.getNome()); %>
            >

            <label for="Cognome">Cognome</label>
            <input type="text" id="Cognome" name="cognome" placeholder="Inserisci Cognome" <% if(type.equals("delete")) out.println("disabled");
                 if(c!=null) out.println("value="+ c.getCognome()); %>>

            <label for="Email">Email</label>
            <input type="text" id="Email" name="email" placeholder="Inserisci Email" <% if(type.equals("delete")) out.println("disabled");
                 if(c!=null) out.println("value="+ c.getEmail()); %>>

            <label for="Tel">Telefono</label>
            <input type="text" id="Tel" name="tel" placeholder="Inserisci telefono" <% if(type.equals("delete")) out.println("disabled");
                 if(c!=null) out.println("value="+ c.getTelefono()); %>>

            <label for="Note">Note</label>
            <input type="text" id="Note" name="note" placeholder="Inserisci Note" <% if(type.equals("delete")) out.println("disabled");
                 if(c!=null) out.println("value="+ c.getNote()); %>>

            <input type="submit" value=<% if(type.equals("delete")) out.println("cancella");
                                          else if(type.equals("insert")) out.println("Inserisci");
                                          else if(type.equals("edit")) out.println("Modifica");
                                          else out.println("NESSUN OP");%>>
        </form>
    </div>

</body>
</html>