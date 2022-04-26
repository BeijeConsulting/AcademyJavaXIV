package it.beije.turing.Ecomm;

import it.beije.turing.Ecomm.Beans.Cliente;
import it.beije.turing.Ecomm.DBUtils.DBInterface;
import it.beije.turing.Ecomm.DBUtils.JPA_Manager;

public class main {

	

	public static void main(String[] args) {
	DBInterface db = new JPA_Manager();	// TODO Auto-generated method stub
	for(Cliente c : db.getClienti())
	{
		System.out.println("HEy");
	}
	}

}
