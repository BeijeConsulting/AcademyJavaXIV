package main.java.it.beije.turing.web;

import main.java.it.beije.turing.JPAContactsManager.ContactDBManager;
import main.java.it.beije.turing.JPAContactsManager.Contatto;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search_contact")
public class SearchContact extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchContact() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        Contatto contact = new Contatto();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");



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

            if (contactsFound.size() == 0) {
                response.sendRedirect("not_found.jsp");

            } else {
                request.getSession().setAttribute("contactsFound", contactsFound);
                response.sendRedirect("search_contacts_result.jsp");
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