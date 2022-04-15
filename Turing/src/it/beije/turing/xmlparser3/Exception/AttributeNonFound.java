package it.beije.turing.xmlparser3.Exception;

/**
 * @author Giuseppe Raddato
 * Data: 15 apr 2022
 */
public class AttributeNonFound extends RuntimeException {
    public AttributeNonFound(String s){
        super("L' attributo "+s+" non è stato trovato");
    }
}
