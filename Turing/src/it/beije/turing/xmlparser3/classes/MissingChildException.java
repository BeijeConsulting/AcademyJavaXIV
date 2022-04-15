package it.beije.turing.xmlparser3.classes;


public class MissingChildException extends RuntimeException {

    public MissingChildException(){
        super("Figli mancanti");
    }
}
