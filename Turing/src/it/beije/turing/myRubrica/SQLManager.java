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
        StringBuilder sql=new StringBuilder("Select * from rubrica WHERE nome LIKE \'"+s+"%\' OR "+
                "cognome LIKE \'"+s+"%\' OR "+
                "email LIKE \'"+s+"%\' OR "+
                "telefono LIKE \'"+s+"%\' OR "+
                "note LIKE \'"+s+"%\'");
        Connection connection=null;
        Statement statement= null;
        ResultSet resultSet=null;
        List<Contatto> result=new ArrayList<>();
        try {
            connection=getConnection();
            statement= connection.createStatement();
            ResultSet rs= statement.executeQuery(sql.toString());

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

        StringBuilder sql= new StringBuilder("INSERT INTO Rubrica Values( ");
        sql.append(" null,");
        sql.append("\'"+c.getNome()+"\',");
        sql.append("\'"+c.getCognome()+"\',");
        sql.append("\'"+c.getEmail()+"\',");
        sql.append("\'"+c.getTelefono()+"\',");
        sql.append("\'"+c.getNote()+"\'");
        sql.append(" )");


        Connection connection=null;
        Statement statement= null;
        try {
            connection = getConnection();
            statement= connection.createStatement();
            result= statement.executeUpdate(sql.toString())>=1;
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
        Statement statement= null;
        boolean b=false;
        StringBuilder sql= new StringBuilder("UPDATE Rubrica SET");
        sql.append(" nome=\'"+c.getNome()+"\'");
        sql.append(", cognome=\'"+c.getCognome()+"\'");
        sql.append(", email=\'"+c.getEmail()+"\'");
        sql.append(", telefono=\'"+c.getTelefono()+"\'");
        sql.append(", note=\'"+c.getNote()+"\'");
        sql.append(" where id=\'"+c.getId()+"\'");

        System.out.println(sql);
        try {
            connection=getConnection();
            statement=connection.createStatement();
           b= statement.executeUpdate(sql.toString()) >= 1;
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
        Statement statement= null;
        boolean b=false;
        StringBuilder sql= new StringBuilder("DELETE From Rubrica ");
        sql.append(" where id=\'"+c.getId()+"\'");

        System.out.println(sql);
        try {
            connection=getConnection();
            statement=connection.createStatement();
            b= statement.executeUpdate(sql.toString()) >= 1;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;

    }

    @Override
    public List<Contatto> contattiDuplicati() {
        //TODO
        return null;
    }

    @Override
    public void unisciContatti() {
        //TODO

    }

    @Override
    public List<Contatto> importFromCVS(String path) {
        //TODO
        return null;
    }

    @Override
    public List<Contatto> importFromXML(String path) {
        //TODO
        return null;
    }

    @Override
    public void exportFromCVS(String path, List<Contatto> contatti) {
        //TODO
    }

    @Override
    public void exportFromXML(String path, List<Contatto> contatti) {
        //TODO
    }
}
