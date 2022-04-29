package it.beije.turing.web.rubrica.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.beije.turing.web.rubrica.Contatto;
import it.beije.turing.web.rubrica.RubricaManager;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/modify_servlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		int realId = -1;
		try{
			realId = Integer.parseInt(id);
		}catch(NumberFormatException nfEx) {
			System.out.println("Inserire un ID valido");
			response.sendRedirect("./main");
			return;
		}
		String name = request.getParameter("name");
		String surname = request.getParameter("lname");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String note = request.getParameter("note");
		
		if(name == null || surname == null || tel == null || email == null) {
			response.sendRedirect("./main");
			return;
		}
		
		Contatto contatto = new Contatto();
		contatto.setId(realId);
		contatto.setNome(name);
		contatto.setCognome(surname);
		contatto.setTelefono(tel);
		contatto.setEmail(email);
		contatto.setNote(note);
		
		//RubricaManager rm = (RubricaManager)session.getAttribute("rubricaManager");
		RubricaManager rm = new RubricaManager();
		
		List<Contatto> tmp = rm.getAllContatti();
		List<Contatto> ris = rm.ModificaContatto(tmp,contatto);
		rm.setAllContatti(ris);
		rm.writeRubricaOnDB(rm.getAllContatti());
		response.sendRedirect("./index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
