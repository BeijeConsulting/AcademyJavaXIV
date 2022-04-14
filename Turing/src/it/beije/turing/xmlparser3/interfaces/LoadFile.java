package it.beije.turing.xmlparser3.interfaces;

import it.beije.turing.xmlparser3.classes.Documento;

import javax.swing.text.Document;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public interface LoadFile {
    public Documento parse(String path);
}
