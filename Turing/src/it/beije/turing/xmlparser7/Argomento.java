package it.beije.turing.xmlparser7;

import java.util.ArrayList;

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

    public static ArrayList<Argomento> argomentoNewInstance(String string) {
        String campo = string.substring(string.indexOf(" "), string.indexOf(">"));
        String[] campoArgomenti = campo.split("\" ");
        String argomento = "";
        String contenuto = "";
        ArrayList<Argomento> argomenti = new ArrayList<>();

        for(int i = 0; i < campoArgomenti.length; i++) {
            String[] split = campoArgomenti[i].split("=");
            argomento = split[0];
            System.out.println("L'argomento è " + argomento);
            contenuto = split[1].replace("\"", " ").trim();
            System.out.println("Il contenuto è " + contenuto);
            argomenti.add(new Argomento(argomento, contenuto));
        }


        return argomenti;

    }

    public String toString() {
        System.out.println("L'argomento è " + argomento);
        return "";
    }
}
