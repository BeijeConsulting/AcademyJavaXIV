package it.beije.turing.web;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/util")
public class UtilServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilServlet()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("ContactServlet doGet");
		
		StringBuilder lista = new StringBuilder();
		
		switch(request.getParameter("post"))
		{
			case "getRubrica":
				System.out.println("GET RUBRICA");
				for(Contatto c : getRubrica())
				{
					lista.append(c.toString() + "\n");
				}
				break;
				
			case "findContact":
				System.out.println("FIND CONTATTO");
				for(Contatto c : findContact(request))
				{
					lista.append(c.toString() + "\n");
				}
				break;
				
			case "findDuplicates":
				System.out.println("FIND DUPLICATES");
				for(Contatto c : findDuplicates())
				{
					lista.append(c.toString() + "\n");
				}
				break;
				
			default:
				break;
		}
		
		response.getWriter().append(lista);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("ContactServlet doPost");

		
		switch(request.getParameter("post"))
		{
			case "modifyContact":
				modifyContact(request);
				break;
				
			case "deleteContact":
				deleteContact(request);
				break;
				
			case "uniteDuplicates":
				uniteDuplicates();
				break;
				
					
			case "addContact":
				addContact(request);
				break;
				
			case "getRubrica":
			case "findContact":
			case "findDuplicates":
				doGet(request, response);
				return;
				
			default:
				break;
		}
		
		response.sendRedirect("index.html");
	}
	
	private List<Contatto> getRubrica()
	{
		JPAhandler jpaHandler = new JPAhandler();
		return jpaHandler.getRubrica("");
	}
	
	private void addContact(HttpServletRequest request)
	{
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String note = request.getParameter("note");
		
		Contatto newContatto = new Contatto(nome, cognome, email, telefono, note);
		JPAhandler jpaHandler = new JPAhandler();
		jpaHandler.addContatto(newContatto);
		
		System.out.println("CONTATTO CREATO");
	}
	
	private List<Contatto> findContact(HttpServletRequest request)
	{
		System.out.println("CONTATTO TROVATO");
		JPAhandler jpaHandler = new JPAhandler();
		return jpaHandler.findContatto(request.getParameter("filtro"));
	}
	
	private void modifyContact(HttpServletRequest request)
	{
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String note = request.getParameter("note");
		
		Contatto contatto = new Contatto(nome, cognome, email, telefono, note);
		
		JPAhandler jpaHandler = new JPAhandler();
		jpaHandler.modifyContatto(Integer.parseInt(request.getParameter("indice")), contatto);			///////CREARE CONTATTO
		
		System.out.println("CONTATTO MODIFICATO");
	}
	
	private void deleteContact(HttpServletRequest request)
	{
		JPAhandler jpaHandler = new JPAhandler();
		jpaHandler.deleteContatto(Integer.parseInt(request.getParameter("indice")));
		
		System.out.println("CONTATTO CANCELLATO");
	}
	
	private List<Contatto> findDuplicates()
	{
		System.out.println("CONTATTI DUPLICATI TROVATI");
		JPAhandler jpaHandler = new JPAhandler();
		return jpaHandler.findDuplicates();
	}
	
	private void uniteDuplicates()
	{
		JPAhandler jpaHandler = new JPAhandler();
		jpaHandler.uniteDuplicates();
		
		System.out.println("CONTATTI UNITI");
	}
	
	private void writer(List<Contatto> contatti)
	{
		try
		{
			File f = new File("index.html");
	        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
	        bw.write("<html><body><h1>Blah, Blah!</h1>");
	        bw.write("<textarea cols=75 rows=10>");
	        for (int ii=0; ii<20; ii++) {
	            bw.write("Blah blah..");
	        }
	        bw.write("</textarea>");
	        bw.write("</body></html>");
	        bw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}