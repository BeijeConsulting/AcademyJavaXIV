package it.beije.turing.Ecomm;

import java.util.List;

import it.beije.turing.Ecomm.Beans.Cliente;
import it.beije.turing.Ecomm.DBUtils.DBInterface;
import it.beije.turing.Ecomm.DBUtils.JPA_Manager;

public class main {

	

	public static void main(String[] args) {
	DBInterface db = new JPA_Manager();	// TODO Auto-generated method stub
	List<Cliente> listClienti = db.getClienti();
	System.out.println(listClienti.get(0).getOrdini().get(0).getCarrello().get(0));
//	if (listClienti.isEmpty())
//	{
//		Cliente c = new Cliente();
//		c.setCognome("Test");
//		c.setNome("Test");
//		c.setEmail("Altro");
//		c.setIndirizzo("Test");
//	}
	}

}
