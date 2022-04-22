package it.beije.turing.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import it.beije.turing.file.CSVManager;
import it.beije.turing.file.XMLManager;
import it.beije.turing.rubrica.Contatto;


public class MyJDBCManager {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "Marazzini");
    }

    public static List<Contatto> getRubrica() {
        List<Contatto> contatti = new ArrayList<Contatto>();

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();

            rs = statement.executeQuery("SELECT * FROM rubrica");

            while (rs.next()) {
                Contatto contatto = new Contatto();
                contatto.setId(rs.getInt("id"));
                contatto.setNome(rs.getString("nome"));
                contatto.setCognome(rs.getString("cognome"));
                contatto.setEmail(rs.getString("email"));
                contatto.setTelefono(rs.getString("telefono"));
                contatto.setNote(rs.getString("note"));
                contatti.add(contatto);
            }

        } catch (ClassNotFoundException cnfEx) {
            cnfEx.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }

        return contatti;
    }

    public static void exportToCSV(String path, String separatore) throws IOException {
        List<Contatto> contatti = getRubrica();
        CSVManager.writeRubricaCSV(contatti, path, separatore);
    }

    public static void exportToXML(String path) throws TransformerConfigurationException, ParserConfigurationException, TransformerException {
        List<Contatto> contatti = getRubrica();
        XMLManager.writeRubricaXML(contatti, path);
    }

    public static void importFromCSV(String path, String separatore, boolean virgolette) throws IOException {
        List<Contatto> contatti = CSVManager.loadRubricaFromCSV(path, separatore, virgolette);

        insertContacts(contatti);
    }

    public static void importFromXML(String path) throws ParserConfigurationException, IOException, SAXException {
        List<Contatto> contatti = XMLManager.loadRubricaFromXML(path);

        insertContacts(contatti);
    }

    public static void insertContacts(List<Contatto> contatti) {
        Connection connection = null;
        PreparedStatement insertPrepStatement = null;

        try {
            connection = getConnection();
            insertPrepStatement = connection.prepareStatement("INSERT INTO rubrica VALUES (null, ?, ?, ?, ?, ?)");

            for(Contatto contatto : contatti) {
                insertPrepStatement.setString(1, contatto.getNome());
                insertPrepStatement.setString(2, contatto.getCognome());
                insertPrepStatement.setString(3, contatto.getEmail());
                insertPrepStatement.setString(4, contatto.getTelefono());
                insertPrepStatement.setString(5, contatto.getNote());
                insertPrepStatement.executeUpdate();
            }
        } catch (ClassNotFoundException cnfEx) {
            cnfEx.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                insertPrepStatement.close();
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
    }

    public static void updateContact(int id, Contatto contatto) {
        Connection connection = null;
        PreparedStatement insertPrepStatement = null;

        try {
            connection = getConnection();
            insertPrepStatement = connection.prepareStatement("UPDATE rubrica SET nome = ?, cognome = ?, email = ?, telefono = ?, note = ? where id = ?");


            insertPrepStatement.setString(1, contatto.getNome());
            insertPrepStatement.setString(2, contatto.getCognome());
            insertPrepStatement.setString(3, contatto.getEmail());
            insertPrepStatement.setString(4, contatto.getTelefono());
            insertPrepStatement.setString(5, contatto.getNote());
            insertPrepStatement.setInt(6, id);
            insertPrepStatement.executeUpdate();

        } catch (ClassNotFoundException cnfEx) {
            cnfEx.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                insertPrepStatement.close();
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
    }

    public static void deleteContact(int id) {
        Connection connection = null;
        PreparedStatement insertPrepStatement = null;

        try {
            connection = getConnection();
            insertPrepStatement = connection.prepareStatement("DELETE FROM rubrica where id = ?");

            insertPrepStatement.setInt(1, id);
            insertPrepStatement.executeUpdate();

        } catch (ClassNotFoundException cnfEx) {
            cnfEx.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                insertPrepStatement.close();
                connection.close();
            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
        }
    }
    //DELETE
    //statement.executeUpdate("DELETE FROM rubrica where id = 4");

    public static void main(String[] args) {
        List<Contatto> contatti = new ArrayList<Contatto>();

        Contatto contatto = new Contatto();
        contatto.setNome("Alessio");
        contatto.setCognome("Marazzini");
        contatto.setEmail("alessio@beije.com");
        contatto.setTelefono("3497007275");
        contatto.setNote("Quinto contatto");
        contatti.add(contatto);

        //insertContacts(contatti);
        updateContact(3, contatto);
        //deleteContact(17);
        List<Contatto> newContatti = getRubrica();
        for(Contatto c : newContatti) {
            System.out.println(c);
        }
    }

}
