package it.beije.turing.web.ecomm;

import java.util.List;

import it.beije.turing.web.ecomm.beans.Transaction;
import it.beije.turing.web.ecomm.beans.Client;
import it.beije.turing.web.ecomm.beans.Order;
import it.beije.turing.web.ecomm.beans.Good;


public interface CommandInterface {
	
	public static CommandInterface getInstance() {
		return null;
		}
	
	//public void importCSV(String fileName, boolean apici);
	
	//public void importXML(String fileName);
	
	public String print();

	public void add(Client c);
	public void add(Order o);
	public void add(Transaction t);
	public void add(Good g);
	
	public void modifyC(int id, String nome, String cognome, String indirizzo, String email);

	public List<Client> getClientList();
	public List<Good> getProductsList();
	public List<Order> getOrdersList();
	public List<Transaction> getTransactionsList();

	public List<Client> searchCliente(String... command);
	public List<Order> searchOrder(String... command);
	public List<Good> searchGood(String... command);
	public List<Transaction> searchTransaction(String... command);

	public void delete(String string);

	public void modifyC(Client c);

	
	
	

}
