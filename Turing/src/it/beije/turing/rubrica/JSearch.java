package it.beije.turing.rubrica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JSearch {
	public static Contatto contactBuilder (ResultSet rs) {
		Contatto contatto = new Contatto();
		try {
			contatto.setId(rs.getInt("id"));
			contatto.setNome(rs.getString("nome"));
			contatto.setCognome(rs.getString("cognome"));
			contatto.setTelefono(rs.getString("telefono"));
			contatto.setEmail(rs.getString("email"));
			contatto.setNote(rs.getString("note"));
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		}
		return contatto;
	}
	
	public static List<Contatto> search (Connection connection) {
		Statement statement = null;
		ResultSet rs = null;
		List<Contatto> results = new ArrayList<>();
		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM rubrica");
			
			Scanner s = new Scanner(System.in);
			System.out.println("What to search for?\n");
			String keyword = s.next();
			System.out.println("What field do you want to search?\n"
					+"1: nome\n"
					+"2: cognome\n"
					+"3: telefono\n"
					+"4: email\n"
					+"5: note\n");
			String st = s.next();
			
			while(true) {
				if (st.equals("exit")) {
					s.close();
					return results;
				}
				switch (st) {
				case "1":
					while (rs.next()) {
						if (rs.getString("nome")!=null && rs.getString("nome").toLowerCase().indexOf(keyword.toLowerCase())!=-1){
							Contatto contatto = contactBuilder(rs);
							results.add(contatto);
						}
					}
					break;
				case "2":
					while (rs.next()) {
						if (rs.getString("cognome")!=null && rs.getString("cognome").toLowerCase().indexOf(keyword.toLowerCase())!=-1){
							Contatto contatto = contactBuilder(rs);
							results.add(contatto);
						}
					}
					break;
				case "3":
					while (rs.next()) {
						if (rs.getString("telefono")!=null && rs.getString("telefono").toLowerCase().indexOf(keyword.toLowerCase())!=-1){
							Contatto contatto = contactBuilder(rs);
							results.add(contatto);
						}
					}
					break;
				case "4":
					while (rs.next()) {
						if (rs.getString("email")!=null && rs.getString("email").toLowerCase().indexOf(keyword.toLowerCase())!=-1){
							Contatto contatto = contactBuilder(rs);
							results.add(contatto);
						}
					}
					break;
				case "5":
					while (rs.next()) {
						if (rs.getString("note")!=null && rs.getString("note").toLowerCase().indexOf(keyword.toLowerCase())!=-1){
							Contatto contatto = contactBuilder(rs);
							results.add(contatto);
						}
					}
					break;
				default:
					System.out.println("invalid input, please enter 1-5 or exit to leave:");
					st = s.next();
					continue;
				}
				System.out.println("Found "+results.size()+" matches.");
				s.close();
				return results;
			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}
		return results;
	}
}
