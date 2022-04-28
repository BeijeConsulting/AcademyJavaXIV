package it.beije.turing.web.rubrica;

import it.beije.turing.web.util.MyJPAManager;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/search_result")
public class SearchResultServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String fname = request.getParameter("fname");
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
            List<Contatto> contactsFound = MyJPAManager.searchContacts(contact);

            if (contactsFound.size() == 0){
                response.sendRedirect("not_found.jsp");

            }else {
                StringBuilder b = new StringBuilder();

                b.append("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "   <meta charset=\"UTF-8\">\n" +
                        "   <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                        "   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "   <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
                        "	<style>\n" +
                        "      body {\n" +
                        "         background-color: #23272e;\n" +
                        "         color: white;\n" +
                        "         min-height: 100vh;\n" +
                        "      }\n" +
                        ".container {\n" +
                        "      padding: 30px 0;\n" +
                        "      width: 80%;\n" +
                        "      min-width: 300px;\n" +
                        "      margin: 0 auto;\n" +
                        "      display: flex;\n" +
                        "      justify-content: center;\n" +
                        "   }" +
                        " 		.table { color: #fff" +"      }\n" +
                        "   </style>" +
                        "   <title>Contatti</title>\n" +
                        "</head>\n" +
                        "<body>" +
                        "<h1 class=\"text-center\">Contatti corrispondenti trovati</h1>" +
                        "<div class=\"container\">" +
                        "<table class=\"table\">\n" +
                        "  <thead>\n" +
                        "    <tr>\n" +
                        "      <th scope=\"col\">#</th>\n" +
                        "      <th scope=\"col\">Nome</th>\n" +
                        "      <th scope=\"col\">Cognome</th>\n" +
                        "      <th scope=\"col\">Telefono</th>\n" +
                        "      <th scope=\"col\">Email</th>\n" +
                        "      <th scope=\"col\">Note</th>\n" +
                        "    </tr>\n" +
                        "  </thead>\n" +
                        "  <tbody>\n" +
                        "<div>"
                );

                for (Contatto contatto : contactsFound) {
                    b.append("<tr>\n" +
                             "      <th scope=\"row\">" + contatto.getId() + "</th>\n" +
                             "      <td>" + contatto.getNome() + "</td>\n" +
                             "      <td>" + contatto.getCognome() + "</td>\n" +
                             "      <td>" + contatto.getTelefono() + "</td>\n" +
                             "      <td>" + contatto.getEmail() + "</td>\n" +
                             "      <td>" + contatto.getNote() + "</td>\n" +
                             "</tr>\n"
                    );
                }

                b.append("  </tbody>\n" +
                        "</table>" +
                        "</body>\n" +
                        "</html>"
                );

                response.getWriter().append(b);
            }
        }



    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
