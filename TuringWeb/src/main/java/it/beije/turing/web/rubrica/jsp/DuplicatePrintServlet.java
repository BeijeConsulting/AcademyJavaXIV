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
 * Servlet implementation class DuplicatePrintServlet
 */
@WebServlet("/duplicate_print_servlet")
public class DuplicatePrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DuplicatePrintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//RubricaManager rm = (RubricaManager)session.getAttribute("rubricaManager");
		RubricaManager rm = new RubricaManager();
		List<Contatto> tmp = rm.TrovaContattiDuplicati(rm.getAllContatti());
		List<Contatto> allContatti = rm.getAllContatti();
		List<Contatto> ris = rm.UnisciContattiDuplicati(allContatti);
		rm.setAllContatti(ris);
		rm.writeRubricaOnDB(rm.getAllContatti());
		
		session.setAttribute("contattiDuplicati", tmp);
		session.setAttribute("allContatti", rm.getAllContatti());
		response.sendRedirect("./duplicate_print.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
