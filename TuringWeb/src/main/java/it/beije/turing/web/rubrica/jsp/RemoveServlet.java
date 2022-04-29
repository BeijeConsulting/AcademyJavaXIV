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
 * Servlet implementation class RemoveServlet
 */
@WebServlet("/remove_servlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int realId = -1;
		try{
			realId = Integer.parseInt(id);
		}catch(NumberFormatException nfEx) {
			System.out.println("Inserire un ID valido");
			response.sendRedirect("./main");
			return;
		}
		HttpSession session = request.getSession();
		//RubricaManager rm = (RubricaManager)session.getAttribute("rubricaManager");
		RubricaManager rm = new RubricaManager();
		List<Contatto> c = rm.getAllContatti();
		List<Contatto> ris = rm.EliminaContatto(c, realId);
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
