package it.beije.turing.web.ecomm;

import java.util.List;

import it.beije.turing.web.ecomm.beans.Client;
import it.beije.turing.web.ecomm.beans.Good;
import it.beije.turing.web.ecomm.beans.Order;
import it.beije.turing.web.ecomm.beans.Transaction;
import it.beije.turing.web.ecomm.dbutils.DBInterface;
import it.beije.turing.web.ecomm.dbutils.JPA_Manager;

public class EcommManager implements CommandInterface {
	private DBInterface db = new JPA_Manager();

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Client c) {
		db.add(c);
	}

	@Override
	public void add(Order o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Transaction t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Good g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyC(int id, String nome, String cognome, String indirizzo, String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Client> getClientList() {
		
		
		return db.getClientList();
	}

	@Override
	public List<Good> getProductsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getOrdersList() {
		// TODO Auto-generated method stub
		return db.getOrderHistory();
	}

	@Override
	public List<Transaction> getTransactionsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> searchCliente(String... command) {
		StringBuilder fields = new StringBuilder();
		for(int i = 0;i<command.length;i+=2)
		{
			fields.append(command[i]+"='"+command[i+1]+"'");
			if(i+1!=command.length-1)
			{
				fields.append(",");
			}
		}
		
		return db.search(fields.toString());
	}

	@Override
	public List<Order> searchOrder(String... command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Good> searchGood(String... command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> searchTransaction(String... command) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String string) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyC(Client c) {
		// TODO Auto-generated method stub

	}

}
