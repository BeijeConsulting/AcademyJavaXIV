package it.beije.turing.xmlparser3.Exception;


public class AttributeNonFound extends RuntimeException {
    public AttributeNonFound(String s){
        super("L' attributo "+s+" non è stato trovato");
    }
}
