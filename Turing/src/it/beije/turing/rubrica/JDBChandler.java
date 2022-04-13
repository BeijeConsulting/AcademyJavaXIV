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
				contatti.add(new Contatto(rs.getString("nome"), rs.getString("cognome"), rs.getString("telefono"), rs.getString("email"), rs.getString("note")));
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