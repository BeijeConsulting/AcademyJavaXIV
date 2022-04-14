package it.beije.turing.xmlparser3.interfaccia;

/**
 * @author Giuseppe Raddato
 * Data: 14 apr 2022
 */
public interface XMLParser{
     void   getRootElement(); //torna l'elemento root
    void  getChildNodes(); //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
    void  getChildElements(); //torna i soli elementi figli dell'elemento su cui viene eseguito
    void getElementsByTagName(String tagName); //torna TUTTI gli elementi con quello specifico nome
    void  getTagName(); //torna il nome del tag
    void getTextContent(); //torna il contenuto del tag
    void getAttributes(); //torna l'elenco degli attributi dell'elemento
    void getAttribute(String attribute); //torna il valore dell'attributo specificato


}
