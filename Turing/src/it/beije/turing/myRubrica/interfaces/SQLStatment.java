package it.beije.turing.myRubrica.interfaces;

/**
 * @author Giuseppe Raddato
 * Data: 20 apr 2022
 */
public class SQLStatment {

    public static final String SEARCH_CONTACTS=
            "Select * from rubrica WHERE nome LIKE ? OR " +
            "cognome LIKE ? OR " +
            "email LIKE ? OR "+
            "telefono LIKE ? OR "+
            "note LIKE ? ";

    public static String INSERT_CONTACT="INSERT INTO Rubrica Values(null, ?,?,?,?,?)";
    public static String MODIFICA_CONTACT="UPDATE Rubrica SET nome=? , cognome=?, email=? , telefono=? , note=? where id=?";
    public static String DELETE_CONTACT="DELETE FROM Rubrica Where ID=?";


}
