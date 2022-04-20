package it.beije.turing.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.beije.turing.rubrica.Contatto;

public class ClassicDBManager implements DbInterface{

	@Override
	public List<Contatto> getContatti() {
		Connection connection=getConnection();
		ResultSet rs = null;
		try {
			Statement query = connection.createStatement();
			rs=query.executeQuery("SELECT * FROM rubrica");
			return readRS(rs);
		} catch (SQLException e) {
			System.out.println("errror while fetchign from DB");
			return null;
		}
	}

	@Override
	public void insertContatti(Contatto c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContatti(Contatto c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contatto getContatto(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	private Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "1234");
		} catch (SQLException e) {
			System.out.println("failed to get connection");
			return null;
		}
	}
	private List<Contatto> readRS(ResultSet rs) throws SQLException
	{
		if(rs!=null)
		{
			List<Contatto> tmp = new ArrayList<>();
			while(rs.next())
			{
				Contatto c = new Contatto();
				c.setId(rs.getInt(1));
				c.setNome(rs.getString(2));
				c.setCognome(rs.getString(3));
				c.setTelefono(rs.getString(4));
				c.setEmail(rs.getString(5));
				c.setNote(rs.getString(6));
				tmp.add(c);
			}
			return tmp;
		}
		return null;
	}
}
