package it.beije.turing.xmlparser3.classes;

/**
 * @author Giuseppe Raddato
 * Data: 15 apr 2022
 */
public class MissingChildException extends RuntimeException {

    public MissingChildException(){
        super("Figli mancanti");
    }
}
