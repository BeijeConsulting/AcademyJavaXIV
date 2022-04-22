package it.beije.turing.rubrica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyJDBCManager {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "verde");
    }

    public static List<Contatto> importRubrica() {

        List<Contatto> contacts = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            contacts = new ArrayList<>();

            //SELECT
            rs = statement.executeQuery("SELECT * FROM rubrica");

            while (rs.next()) {
                Contatto contact = new Contatto();
                contact.setId(rs.getInt("id"));
                contact.setNome(rs.getString("nome"));
                contact.setCognome(rs.getString("cognome"));
                contact.setTelefono(rs.getString("telefono"));
                contact.setEmail(rs.getString("email"));
                contact.setNote(rs.getString("note"));

                System.out.println(contact);

                contacts.add(contact);
            }

        } catch (ClassNotFoundException | SQLException cnfEx) {
            cnfEx.printStackTrace();
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

        return contacts;
    }

    public static void exportRubrica(List<Contatto> contacts) {

        Connection connection = null;
        PreparedStatement insertPrepStatement = null;
        try {
            connection = getConnection();
            String SQLStatement = "INSERT INTO rubrica VALUES (null, ?, ?, ?, ?, ?)";
            insertPrepStatement = connection.prepareStatement(SQLStatement);

            for (Contatto c : contacts) {
                //INSERT
                insertPrepStatement.setString(1, c.getNome());
                insertPrepStatement.setString(2, c.getCognome());
                insertPrepStatement.setString(3, c.getEmail());
                insertPrepStatement.setString(4, c.getTelefono());
                insertPrepStatement.setString(5, c.getNote());

                insertPrepStatement.executeUpdate();
            }

        } catch (ClassNotFoundException | SQLException cnfEx) {
            cnfEx.printStackTrace();
        } finally {
            try {
                insertPrepStatement.close();
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
    }

    public static List<Contatto> searchContactBy(String word) {
        List<Contatto> contacts = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            contacts = new ArrayList<>();
            String[] cols = {"nome", "cognome", "telefono", "email", "note", };

            for (String colName : cols) {

                String SQLStatement = "SELECT * FROM rubrica WHERE " + colName + " LIKE '%" + word + "%'";
                //SELECT
                rs = statement.executeQuery(SQLStatement);

                while (rs.next()) {
                    Contatto contact = new Contatto();
                    contact.setId(rs.getInt("id"));
                    contact.setNome(rs.getString("nome"));
                    contact.setCognome(rs.getString("cognome"));
                    contact.setTelefono(rs.getString("telefono"));
                    contact.setEmail(rs.getString("email"));
                    contact.setNote(rs.getString("note"));

                    contacts.add(contact);
                }
            }

        } catch (ClassNotFoundException | SQLException cnfEx) {
            cnfEx.printStackTrace();
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

        return contacts;
    }

}
