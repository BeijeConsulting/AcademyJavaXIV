package it.beije.turing.xmlparser3.interfaces;

import it.beije.turing.xmlparser3.classes.Documento;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public interface ILoadFile {
    /**
     * Carica il file il memoria e crea un oggetto di quel file
     * @param file path del file
     * @return Documento
     */
    public Documento parse(String file);
}
