package it.beije.turing.rubrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBChandler
{
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "MattiaPagani");
	}
	
	public void test()
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			connection = getConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate("DELETE FROM rubrica where id = 7");
			statement.executeUpdate("DELETE FROM rubrica where id = 6");
			statement.executeUpdate("DELETE FROM rubrica where id = 5");
			statement.executeUpdate("DELETE FROM rubrica where id = 3");
			statement.executeUpdate("DELETE FROM rubrica where id = 2");
			statement.executeUpdate("DELETE FROM rubrica where id = 1");
			//statement.executeUpdate("INSERT INTO rubrica VALUES (null, 'Gianni', 'Blu', 'g.blu@beije.it', '5355223532', 'Una Bella Nota')");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
				connection.close();
			}
			catch (SQLException sqlEx)
			{
				sqlEx.printStackTrace();
			}
		}
	}
	
	public List<Contatto> getRubrica(String filtro)
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		List<Contatto> contatti = new ArrayList<>();
		
		if (filtro != "") riordinaRubrica(filtro);
		
		try
		{
			connection = JDBChandler.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM rubrica");
			
			while (rs.next())
			{
				contatti.add(new Contatto(rs.getInt("id"), rs.getString("nome"), rs.getString("cognome"), rs.getString("telefono"), rs.getString("email"), rs.getString("note")));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				statement.close();
				connection.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return contatti;
	}
	
	private void riordinaRubrica(String filtro)
	{
		List<Contatto> contatti = getRubrica("");
		
		switch(filtro)
		{
			case "nome":
				contatti.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
				break;
				
			case "cognome":
				contatti.sort((o1, o2) -> o1.getCognome().compareTo(o2.getCognome()));
				break;
				
			case "telefono":
				contatti.sort((o1, o2) -> o1.getTelefono().compareTo(o2.getTelefono()));
				break;
				
			case "email":
				contatti.sort((o1, o2) -> o1.getEmail().compareTo(o2.getEmail()));
				break;
				
			case "note":
				contatti.sort((o1, o2) -> o1.getNote().compareTo(o2.getNote()));
				break;
				
			default:
				return;
		}
		
		clearDB();
		loadRubricaToDB(contatti);
	}
	
	private void clearDB()
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			connection = JDBChandler.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM rubrica");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
				connection.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public List<Contatto> findContatto(String filtro)
	{
		List<Contatto> cont = new ArrayList<>();
		List<Contatto> contatti = getRubrica("");
		
		for(Contatto contatto : contatti)
		{
			if (contatto.getNome().equals(filtro)) cont.add(contatto);
			else if (contatto.getCognome().equals(filtro)) cont.add(contatto);
			else if (contatto.getTelefono().equals(filtro)) cont.add(contatto);
			else if (contatto.getEmail().equals(filtro)) cont.add(contatto);
			else if (contatto.getNote().equals(filtro)) cont.add(contatto);
		}
		
		return cont;
	}
	
	public boolean addContatto(Contatto c)
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO rubrica VALUES (null, '" + c.getNome() + "', '"+ c.getCognome() + "', '" + c.getEmail() + 
					"', '" + c.getTelefono() + "', '" + c.getNote() + "')");
		}
		catch (ClassNotFoundException cnfEx)
		{
			cnfEx.printStackTrace();
			return false;
		}
		catch (SQLException sqlEx)
		{
			sqlEx.printStackTrace();
			return false;
		}
		finally
		{
			try
			{
				statement.close();
				connection.close();				
			}
			catch (SQLException sqlEx)
			{
				sqlEx.printStackTrace();
			}
		}
		
		return true;
	}
	
	public void modifyContatto(int pos, Contatto c)
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeUpdate("UPDATE rubrica SET nome = '" + c.getNome() + "', cognome = '" + c.getCognome() + "', telefono = '"
									+ c.getTelefono() + "', email = '" + c.getEmail()
									+ "', note = '" + c.getNote() + "' where id = " + pos);
		}
		catch (ClassNotFoundException cnfEx)
		{
			cnfEx.printStackTrace();
		}
		catch (SQLException sqlEx)
		{
			sqlEx.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
				connection.close();
			}
			catch (SQLException sqlEx)
			{
				sqlEx.printStackTrace();
			}
		}
	}
	
	public void deleteContatto(int posizione)
	{
		Connection connection = null;
		Statement statement = null;
		
		try
		{
			connection = getConnection();
			statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM rubrica where id = " + posizione);
		}
		catch (ClassNotFoundException cnfEx)
		{
			cnfEx.printStackTrace();
		}
		catch (SQLException sqlEx)
		{
			sqlEx.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
				connection.close();
			}
			catch (SQLException sqlEx)
			{
				sqlEx.printStackTrace();
			}
		}
	}
	
	public List<Contatto> findDuplicates()
	{
		List<Contatto> contatti = getRubrica("");
		List<Contatto> duplicati = new ArrayList<>();
		
		for(int i = 0; i < contatti.size(); i++)
		{
			for(int j = i; j < contatti.size(); j++)
			{				
				if (i == j) continue;
				if (contatti.get(i).equals(contatti.get(j)))
				{
					duplicati.add(contatti.get(j));
					contatti.remove(j);
					j = j-1;
				}
			}
		}
		
		return duplicati;
	}
	
	public void uniteDuplicates()
	{
		List<Contatto> duplicati = findDuplicates();
		
		for(Contatto c : duplicati)
		{
			deleteContatto(c.getId());
		}		
	}
	
	public void loadRubricaToDB(List<Contatto> contatti)
	{
		Connection connection = null;
		Statement statement = null;

		try
		{
			connection = getConnection();
			statement = connection.createStatement();
			
			for(Contatto contatto : contatti)
			{
				statement.executeUpdate("INSERT INTO rubrica VALUES (null, '" + contatto.getNome() + "', '"+ contatto.getCognome() + "', '" + contatto.getTelefono() + 
						"', '" + contatto.getEmail() + "', '" + contatto.getNote() + "')");
			}
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				statement.close();
				connection.close();
			}
			catch (SQLException sqlEx)
			{
				sqlEx.printStackTrace();
			}
		}
	}
	
	public List<Contatto> writeRubricaFromDB()
	{
		List<Contatto> contatti = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try
		{
			connection = getConnection();
			statement = connection.createStatement();
			
			rs = statement.executeQuery("SELECT * FROM rubrica");
			
			while (rs.next())
			{
				contatti.add(new Contatto(rs.getInt("id"), rs.getString("nome"), rs.getString("cognome"), rs.getString("telefono"), rs.getString("email"), rs.getString("note")));
			}
		}
		catch (ClassNotFoundException cnfEx)
		{
			cnfEx.printStackTrace();
		}
		catch (SQLException sqlEx)
		{
			sqlEx.printStackTrace();
		}
		finally
		{
			try
			{
				rs.close();
				statement.close();
				connection.close();
				
			}
			catch (SQLException sqlEx)
			{
				sqlEx.printStackTrace();
			}
		}
		
		return contatti;
	}
}