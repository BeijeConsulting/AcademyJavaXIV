package it.beije.turing.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.turing.web.rubrica.CommandInterface;
import it.beije.turing.web.rubrica.bean.Contatto;

/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/main")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandInterface link;
	private final String jsp = "UI.jsp";
	private final String fjsp = "Form.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        link=CommandInterface.getInstance();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("list", link.getList());
		request.getSession().setAttribute("mode", "main");
		response.sendRedirect(jsp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command.contains(" "))
		{
			String[]tmp=command.split(" ");
			command=tmp[0];
		}
		switch (command) {
		case "back":
			request.getSession().setAttribute("mode", "main");
			doGet(request, response);
			break;
			
			
		case "new":
			if(request.getParameter("flag2")==null)
			{
				request.getSession().setAttribute("contatto", new Contatto());
				request.getSession().setAttribute("type", "new");
				response.sendRedirect(fjsp);
			}
			
			if(request.getParameter("flag2")!=null)
				{
				String[] tmp = getForm(request);
					link.add(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4]);
					request.getSession().setAttribute("mode", "main");
					doGet(request, response);
				}
		
			break;
			
			
		case "modify":
			if(request.getParameter("flag") != null&&request.getParameter("flag2")==null)
			{
				request.getSession().setAttribute("contatto", link.search("id",(String)request.getParameter("id")).get(0));
				request.getSession().setAttribute("type", "modify");
				response.sendRedirect(fjsp);
			}
			else if(request.getParameter("flag2")!=null)
			{
				String[] tmp = getForm(request);
				link.modify(Integer.parseInt(tmp[5]), tmp[0], tmp[1], tmp[2], tmp[3], tmp[4]);
				request.getSession().setAttribute("mode", "main");
				doGet(request, response);
			}
			else {
			request.getSession().setAttribute("mode", "modify");
			response.sendRedirect(jsp);
			}
			break;
			
			
		case "delete":
			if(request.getParameter("flag") !=null)
			{
				String id=request.getParameter("id");
				if(id!=null)
				{
					link.delete(id);
					request.getSession().setAttribute("mode", "main");
				}
				doGet(request, response);
			}
			else
			{
			request.getSession().setAttribute("mode","delete");
			response.sendRedirect(jsp);
			}
			break;
		case "search":
			if(request.getParameter("flag2")==null)
			{
				request.getSession().setAttribute("contatto", new Contatto());
				request.getSession().setAttribute("type", "search");
				response.sendRedirect(fjsp);
			}
			
			if(request.getParameter("flag2")!=null)
				{
				String[] tmp = getForm(request);
				String[] fields= {"nome","cognome","telefono","email","note"};
				List<String> args = new ArrayList<>();
				for(int i=0;i<tmp.length-1;i++)
				{
					if(tmp[i]!=null&&!tmp[i].equalsIgnoreCase(""))
					{
						args.add(fields[i]);
						args.add(tmp[i]);
					}
				}
				request.getSession().setAttribute("list", link.search(args.toArray(new String[0])));
					request.getSession().setAttribute("mode", "main");
					response.sendRedirect(jsp);
				}
		
			break;
			
			
		default:
			break;
		}
		
	}

	private String makeForm() {
		return null;
		// TODO Auto-generated method stub
		
	}

	private String[] getForm(HttpServletRequest req)
	{
		String[] tmp = new String[6];
		tmp[0]=req.getParameter("nome");
		tmp[1]=req.getParameter("cognome");
		tmp[2]=req.getParameter("telefono");
		tmp[3]=req.getParameter("email");
		tmp[4]=req.getParameter("note");
		tmp[5]=req.getParameter("id");
		for(String s:tmp)
		{
			if(s==null)
			{
				s="";
			}
		}
		return tmp;
		
	}

	
}
