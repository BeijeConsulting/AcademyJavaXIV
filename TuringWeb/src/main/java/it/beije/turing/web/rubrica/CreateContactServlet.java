package it.beije.turing.web.rubrica;

import it.beije.turing.web.util.MyJPAManager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create_contact")
public class CreateContactServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String notes = request.getParameter("notes");

        Contatto contact = new Contatto();
        if (!fname.equals("")) contact.setNome(fname);
        if (!lname.equals("")) contact.setCognome(lname);
        if (!phone.equals("")) contact.setTelefono(phone);
        if (!email.equals("")) contact.setEmail(email);
        if (!notes.equals("")) contact.setNote(notes);

        if ((contact.getNome() == null) &&
            (contact.getCognome() == null) &&
            (contact.getTelefono() == null) &&
            (contact.getEmail() == null) &&
            (contact.getNote() == null)
        ) response.sendRedirect("invalid_form.jsp");
        else {
            MyJPAManager.createContact(contact);

            response.sendRedirect("index.html");
        }
    }
}
