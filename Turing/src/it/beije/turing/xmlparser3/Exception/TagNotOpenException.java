package it.beije.turing.xmlparser3.Exception;

public class TagNotOpenException extends RuntimeException {
    public TagNotOpenException(){
        super("Il tag non è stato aperto");
    }
}
