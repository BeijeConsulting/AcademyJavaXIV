package it.beije.turing.xmlparser3.interfaces;

import it.beije.turing.xmlparser3.classes.Documento;


/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */

public interface LoadFile {
    public Documento parse(String path);
}