package it.beije.turing.myRubrica.db;

import it.beije.turing.myRubrica.interfaces.OpRubrica;
import it.beije.turing.myRubrica.interfaces.Order;
import it.beije.turing.myRubrica.interfaces.SQLStatment;
import it.beije.turing.rubrica.Contatto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Giuseppe Raddato
 * Data: 19 apr 2022
 */
public class SQLManager implements OpRubrica {



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
        StringBuilder s = new StringBuilder( "SELECT c.* FROM Rubrica as c");
        Statement statement= null;
        Connection connection=null;
        ResultSet resultSet = null;
        try {
            connection=getConnection();
             statement= connection.createStatement();

            if(order==Order.NO){

            }else if(order==Order.COGNOME){
                s.append(" ORDER BY nome DESC");
            }else if(order==Order.NOME){
                s.append(" ORDER BY cognome DESC");
            }
            boolean r = statement.execute(s.toString());
            if(r){
                 resultSet= statement.getResultSet();

                while (resultSet.next()){
                   lista.add(createContatto(resultSet));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
        }finally {
            close(connection, statement, resultSet);
        }

        return lista;
    }

    private Contatto createContatto(ResultSet resultSet) throws SQLException {
        Contatto c = new Contatto();
        c.setId(resultSet.getInt("ID"));
        c.setNome(resultSet.getString("Nome"));
        c.setCognome(resultSet.getString("Cognome"));
        c.setEmail(resultSet.getString("Email"));
        c.setTelefono(resultSet.getString("Telefono"));
        c.setNote(resultSet.getString("Note"));
        return c;
    }

    @Override
    public List<Contatto> search(String s) {


        Connection connection=null;
        PreparedStatement statement= null;
        ResultSet resultSet=null;
        List<Contatto> result=new ArrayList<>();
        s="%"+s+"%";
        try {
            connection=getConnection();
            statement= connection.prepareStatement(SQLStatment.SEARCH_CONTACTS);
            statement.setString(1,s);
            statement.setString(2,s);
            statement.setString(3,s);
            statement.setString(4,s);
            statement.setString(5,s);

            statement.execute();
            ResultSet rs= statement.getResultSet();

            while (rs.next()){
                result.add(createContatto(rs));
            }

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            close(connection, statement, resultSet);
        }
        return result;
    }

    @Override
    public boolean insert(Contatto c) {
        boolean result=false;
        Connection connection=null;
        PreparedStatement statement= null;
        try {
            connection = getConnection();
            statement= connection.prepareStatement(SQLStatment.INSERT_CONTACT);
            statement.setString(1,c.getNome());
            statement.setString(2,c.getCognome());
            statement.setString(3,c.getEmail());
            statement.setString(4,c.getTelefono());
            statement.setString(5,c.getNote());
            result= statement.execute();
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean modificaContatto(Contatto c) {
        Connection connection=null;
        PreparedStatement statement= null;
        boolean b=false;


        try {
            connection=getConnection();
            statement=connection.prepareStatement(SQLStatment.MODIFICA_CONTACT);
            statement.setString(1,c.getNome());
            statement.setString(2,c.getCognome());
            statement.setString(3,c.getEmail());
            statement.setString(4,c.getTelefono());
            statement.setString(5,c.getNote());
            statement.setInt(6,c.getId());
           b= statement.execute();
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean deleteContatto(Contatto c) {
        Connection connection=null;
        PreparedStatement statement= null;
        boolean b=false;

        try {
            connection=getConnection();
            statement=connection.prepareStatement(SQLStatment.DELETE_CONTACT);
            statement.setInt(1,c.getId());
            b= statement.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;

    }

    @Override
    public List<List<Contatto>> contattiDuplicati() {
        //TODO
        return null;
    }

    @Override
    public void unisciContatti(List<List<Contatto>> l) {
        //TODO

    }

    @Override
    public List<Contatto> importFromCVS(String path,String separator) {
        //TODO
        return null;
    }

    @Override
    public List<Contatto> importFromXML(String path) {
        //TODO
        return null;
    }

    @Override
    public void exportFromCVS(String path, List<Contatto> contatti,String separator) {
        //TODO
    }

    @Override
    public void exportFromXML(String path, List<Contatto> contatti) {
        //TODO
    }
}
