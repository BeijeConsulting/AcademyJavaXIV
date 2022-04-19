package it.beije.turing.myRubrica;

import it.beije.turing.rubrica.Contatto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 19 apr 2022
 */
public class SQLManager implements OpRubrica{



    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/turing?serverTimezone=CET", "root", "rootroot");
    }


    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(statement!=null){
                statement.close();
            }
            if(resultSet!=null){
                resultSet.close();
            }
            if(connection!=null){
                connection.close();
            }


        } catch (SQLException e) {
           e.printStackTrace();
        }
    }


    public SQLManager(){

    }


    @Override
    public List<Contatto> showContact(Order order) {
        List<Contatto> lista= new ArrayList<>();
        StringBuilder s = new StringBuilder( "SELECT * FROM rubrica");
        Statement statement= null;
        Connection connection=null;
        ResultSet resultSet = null;
        try {
            connection=getConnection();
             statement= connection.createStatement();

            if(order==Order.NO){

            }else if(order==Order.COGNOME){
                s.append(" ORDER BY nome");
            }else if(order==Order.NOME){
                s.append(" ORDER BY cognome");
            }
            boolean r = statement.execute(s.toString());
            if(r){
                 resultSet= statement.getResultSet();
                while (resultSet.next()){
                    Contatto c = new Contatto();
                    c.setId(resultSet.getInt("ID"));
                    c.setNome(resultSet.getString("Nome"));
                    c.setCognome(resultSet.getString("Cognome"));
                    c.setEmail(resultSet.getString("Email"));
                    c.setTelefono(resultSet.getString("Telefono"));
                    c.setEmail(resultSet.getString("Email"));
                    lista.add(c);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
        }finally {
            close(connection, statement, resultSet);
        }







        return lista;
    }

    @Override
    public List<Contatto> search(String s) {
        return null;
    }

    @Override
    public void insert(Contatto c) {

    }

    @Override
    public void modificaContatto(Contatto c) {

    }

    @Override
    public void deleteContatto(Contatto c) {

    }

    @Override
    public List<Contatto> contattiDuplicati() {
        return null;
    }

    @Override
    public void unisciContatti() {

    }

    @Override
    public List<Contatto> importFromCVS(String path) {
        return null;
    }

    @Override
    public List<Contatto> importFromXML(String path) {
        return null;
    }

    @Override
    public void exportFromCVS(String path, List<Contatto> contatti) {

    }

    @Override
    public void exportFromXML(String path, List<Contatto> contatti) {

    }
}
