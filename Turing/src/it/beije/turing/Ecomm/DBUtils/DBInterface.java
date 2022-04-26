package it.beije.turing.Ecomm.DBUtils;

import java.util.List;

import it.beije.turing.Ecomm.Beans.*;

public interface DBInterface {
	
	//Selects
	List<Cliente> getClienti();
	List<Ordine> getOrderHistory();
	List<Prodotto> getInventory();
	
	
}
