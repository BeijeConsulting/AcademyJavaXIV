package it.beije.turing;

import it.beije.turing.myRubrica.MyRubrica;
import it.beije.turing.myRubrica.interfaces.OpRubrica;
import it.beije.turing.rubrica.Contatto;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Giuseppe Raddato
 * Data: 22 apr 2022
 */
public class MainProv {
    public static void main(String[] args) {
        String pathXML="/Users/giusepperaddato/Codici/Java/SpringExample/Getting Started Guides/AcademyJavaXIV/Turing/src/main/resources/file/xml/rubrica(Copia).xml";
      //  List<Contatto> contattos= OpRubrica.impotFileXML(path);

        String pathCVS="/Users/giusepperaddato/Codici/Java/SpringExample/Getting Started Guides/AcademyJavaXIV/Turing/src/main/resources/file/csv/rubrica.csv";

        List<Contatto> contattos=OpRubrica.importFileCVS(pathCVS,";");
        System.out.println(contattos.size());
        MyRubrica.print(contattos);

    }

    private static List<Contatto> getRandom(){
        List<Contatto> contattos= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Contatto c = new Contatto();
            c.setNome("Nome "+i);
            c.setCognome("Cognome "+i);
            c.setEmail("Email "+i);
            c.setTelefono("Tel "+i);
            c.setNote("Note "+i);
            contattos.add(c);
        }
        return contattos;
    }
}
