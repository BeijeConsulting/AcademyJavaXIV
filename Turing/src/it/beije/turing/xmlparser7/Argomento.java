package it.beije.turing.xmlparser7;

public class Argomento {

    private String argomento;
    private String contenuto;

/////////////////////////////////////// COSTRUTTORE ////////////////////////////////////////////////////////////////


    public Argomento(String argomento, String contenuto) {

        this.argomento = argomento;
        this.contenuto = contenuto;
    }

/////////////////////////////////////////////////////////////        GET E SET         ///////////////////////////////////////////

    public String getArgomento() {
        return argomento;
    }



    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }



    public String getContenuto() {
        return contenuto;
    }



    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
