package it.beije.turing.web.ecomm.dbutils;

import java.util.List;

import it.beije.turing.web.ecomm.beans.*;

public interface DBInterface {
	
	//Selects
	List<Client> getClientList();
	List<Order> getOrderHistory();
	List<Good> getInventory();
	List<Client> search(String fields);
	void add(Client c);
	
	
	
}
