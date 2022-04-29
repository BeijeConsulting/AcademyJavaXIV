package it.beije.turing.web.ecomm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.turing.web.ecomm.CommandInterface;


import it.beije.turing.web.ecomm.beans.Transaction;
import it.beije.turing.web.ecomm.beans.Client;
import it.beije.turing.web.ecomm.beans.Order;
import it.beije.turing.web.ecomm.beans.Good;


/**
 * Servlet implementation class NewServlet
 */
@WebServlet("/emain")
public class EcommServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandInterface link;
	private final String jsp = "EUI.jsp";
	private final String fjsp = "Eform.jsp";
	private final String orderHistory="OrdH.jsp";
	private final String ofjsp ="OrderForm.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EcommServlet() {
        super();
        link=CommandInterface.getInstance();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("list", link.getClientList());
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
				request.getSession().setAttribute("client", new Client());
				request.getSession().setAttribute("type", "new");
				response.sendRedirect(fjsp);
			}
			
			if(request.getParameter("flag2")!=null)
				{
				Client c = getForm(request);
					link.add(c);
					request.getSession().setAttribute("mode", "main");
					doGet(request, response);
				}
		
			break;
			
			
		case "modify":
			if(request.getParameter("flag") != null&&request.getParameter("flag2")==null)
			{
				request.getSession().setAttribute("contatto", link.searchCliente("id",(String)request.getParameter("id")).get(0));
				request.getSession().setAttribute("type", "modify");
				response.sendRedirect(fjsp);
			}
			else if(request.getParameter("flag2")!=null)
			{
				Client c = getForm(request);
				link.modifyC(c);
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
				request.getSession().setAttribute("contatto", new Client());
				request.getSession().setAttribute("type", "search");
				response.sendRedirect(fjsp);
			}
			
			else if(request.getParameter("flag2")!=null)
				{
				Client c = getForm(request);
				String[] fields= {"nome","cognome","indirizzo","email"};
				List<String> args = new ArrayList<>();
				String tmp;
				if(!(tmp=c.getNome()).equals("")){args.add("nome");  args.add(tmp);}
				if(!(tmp=c.getCognome()).equals("")) {args.add("cognome");  args.add(tmp);}
				if(!(tmp=c.getIndirizzo()).equals("")){args.add("indirizzo");  args.add(tmp);}
				if(!(tmp=c.getEmail()).equals("")) {args.add("email");  args.add(tmp);}
				if(!args.isEmpty()) {
				request.getSession().setAttribute("list", link.searchCliente(args.toArray(new String[0])));
				response.sendRedirect(jsp);
				}
				else
				doGet(request,response);
				}
		
			break;
			
		case "orders":
			request.getSession().setAttribute("olist", link.getOrdersList());
			response.sendRedirect(orderHistory);
			break;
			
		case "showOrders":
			if(request.getParameter("flag")!=null) {
			List<Order> olist = link.searchCliente("id", (String)request.getParameter("id")).get(0).getOrdini();
			request.getSession().setAttribute("olist",olist);
			response.sendRedirect(orderHistory);
			}
			else 
			{
				request.getSession().setAttribute("mode", "showOrders");
				response.sendRedirect(jsp);
			}
			break;
			
		case "addOrder":
			if(request.getParameter("flag")!=null&&request.getParameter("flag2")==null)
			{
				request.getSession().setAttribute("order", new Order());
				request.getSession().setAttribute("type", "new");
				response.sendRedirect(ofjsp);
			}
			else if(request.getParameter("flag2")!=null)
				{
				Client c = link.searchCliente("id", (String)request.getParameter("id")).get(0);
				c.getOrdini().add((Order)request.getSession().getAttribute("order"));
					link.modifyC(c);
					request.getSession().setAttribute("mode", "main");
					doGet(request, response);
				}
			else {
				request.getSession().setAttribute("mode", "addOrder");
				response.sendRedirect(jsp);
				}
		
			break;
			
			
		
			
		default:
			break;
		}
		
	}


	private Client getForm(HttpServletRequest req)
	{
		Client c = new Client();
		c.setNome(req.getParameter("nome"));
		c.setCognome(req.getParameter("cognome"));
		c.setIndirizzo(req.getParameter("telefono"));
		c.setEmail(req.getParameter("email"));
		c.setId(Integer.parseInt(req.getParameter("id")));
		return c;
		
	}

	
}
