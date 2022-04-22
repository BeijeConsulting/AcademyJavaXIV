package it.beije.turing.rubrica;

import it.beije.turing.db.JPAcriteria;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RubricaContatti {

    private List<Contatto> listaContatti = new ArrayList<Contatto>();
    private JPAcriteria jpAcriteria;

    public RubricaContatti() {
        jpAcriteria = new JPAcriteria();
    }

    public void leggiContatti() {

        List<Contatto> contattos = jpAcriteria.JPACriteriaLeggiContatti();
        listaContatti = (ArrayList<Contatto>) contattos;
        for (Contatto c : contattos) {
            System.out.println(c.toString());
        }
    }

    public void cercaContatto() {


        Scanner in = new Scanner(System.in);
        ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();

        System.out.println("Inserisci elemento da cercare: ");
        String elemento = in.nextLine();


        System.out.println("Inserisci tipo di elemento da cercare: ");
        System.out.println("1. Nome ");
        System.out.println("2. Cognome ");
        System.out.println("3. Numero ");
        System.out.println("4. Email  ");

        String scelta = in.nextLine();
        if (scelta.equals("")) {
            System.out.print("Scelta non valida");
        }

        System.out.println("Bene");

        switch (scelta) {

            case "1":
                System.out.println(" I Risutati sono: ");
                contattiTrovati = filtraPerNome(elemento);
                stampa(contattiTrovati);
                break;

            case "2":

                System.out.println(" I Risutati sono: ");
                contattiTrovati = filtraPerCognome(elemento);
                stampa(contattiTrovati);
                break;

            case "3":
                System.out.println(" I Risutati sono: ");
                contattiTrovati = filtraPerTelefono(elemento);
                stampa(contattiTrovati);
                break;

            case "4":

                System.out.println(" I Risutati sono: ");
                contattiTrovati = filtraPerEmail(elemento);
                stampa(contattiTrovati);
                break;
            default:

                System.out.println("Indice sbagliato");

        }


    }

    private void stampa(ArrayList<Contatto> contattiTrovati) {

        for (Contatto c : contattiTrovati) {
            System.out.println(c.toString());
        }
    }

/////////////////////////////////////////		FILTRA PER  EMAIL

    private ArrayList<Contatto> filtraPerEmail(String elemento) {

        ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();

        for (Contatto c : listaContatti) {

            if (c.getEmail().equalsIgnoreCase(elemento)) {
                contattiTrovati.add(c);
            }
        }

        return contattiTrovati;
    }


//////////////////////////////////////		FILTRA PER TELEFONO

    private ArrayList<Contatto> filtraPerTelefono(String elemento) {

        ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();

        for (Contatto c : listaContatti) {

            if (c.getTelefono().equalsIgnoreCase(elemento)) {
                contattiTrovati.add(c);
            }
        }

        return contattiTrovati;
    }


    //////////////////////////////////////     FILTRA PER NOME
    private ArrayList<Contatto> filtraPerNome(String elemento) {

        ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();

        for (Contatto c : listaContatti) {

            if (c.getNome().equalsIgnoreCase(elemento)) {
                contattiTrovati.add(c);
            }
        }

        return contattiTrovati;
    }

////////////////////////////////////////	 FILTRA PER COGNOME			 ////////////////////////////////////////////////////////////////////////////////

    private ArrayList<Contatto> filtraPerCognome(String elemento) {

        ArrayList<Contatto> contattiTrovati = new ArrayList<Contatto>();

        for (Contatto c : listaContatti) {

            if (c.getCognome().equalsIgnoreCase(elemento)) {
                contattiTrovati.add(c);
            }
        }

        return contattiTrovati;
    }

    public void aggiungiContatto() {


        Scanner in = new Scanner(System.in);
        Contatto contattoNuovo = new Contatto();

        System.out.println("Inserisci Nome : ");
        String nome = in.nextLine();
        if (nome.equals("")) {
            System.out.print("Nome inesistente \n");
        }
        System.out.println("Inserisci Cognome : ");
        String cognome = in.nextLine();
        if (cognome.equals("")) {
            System.out.print("Cognome inesistente \n");
        }
        System.out.println("Inserisci email : ");
        String email = in.nextLine();
        if (email.equals("")) {
            System.out.print("Email inesistente \n");
        }
        System.out.println("Inserisci telefono : ");
        String telefono = in.nextLine();
        if (telefono.equals("")) {
            System.out.print("Telefono inesistente \n");
        }

        System.out.println("Inserisci note : ");
        String note = in.nextLine();
        if (note.equals("")) {
            System.out.print("Note inesistenti \n");
        }

        contattoNuovo.setNome(nome.trim());
        contattoNuovo.setCognome(cognome.trim());
        contattoNuovo.setEmail(email.trim());
        contattoNuovo.setTelefono(telefono.trim());
        contattoNuovo.setNote(nome.trim());

        jpAcriteria.JPAaggiungiContatto(contattoNuovo);

    }


    public void eliminaContatto() {

        List<Contatto> contattos = jpAcriteria.JPACriteriaLeggiContatti();
        listaContatti = (ArrayList<Contatto>) contattos;
        for (Contatto c : contattos) {
            System.out.println(c.toString());

        }


        Scanner in = new Scanner(System.in);
        Contatto contatto = new Contatto();

        System.out.println(" Id dell'elemento da eliminare : ");
        String numero = in.nextLine();
        if (numero.equals("")) {
            System.out.print("Nome non valido ");
        }
        int num = Integer.parseInt(numero);

        for (Contatto c : contattos) {
            if (num == c.getId()) {
                jpAcriteria.delete(c);
            }

        }


    }

    public void modificaContatto() {

        List<Contatto> contattos = jpAcriteria.JPACriteriaLeggiContatti();
        listaContatti = (ArrayList<Contatto>) contattos;
        for (Contatto c : contattos) {
            System.out.println(c.toString());

        }

        Scanner in = new Scanner(System.in);
        Contatto contatto = new Contatto();

        System.out.println(" Id dell'elemento da modificare : ");
        String numero = in.nextLine();
        if (numero.equals("")) {
            System.out.print("Nome non valido ");
        }
        int num = Integer.parseInt(numero);


        for (Contatto c : contattos) {
            if (num == c.getId()) {
                System.out.println("Andiamo a modificare i campi! (premi 'NO' per non modificare)  : ");
                System.out.println("Aggiorna Nome : ");
                String nome = in.nextLine();
                System.out.println("Aggiorna Cognome : ");
                String cognome = in.nextLine();
                System.out.println("Aggiorna Email : ");
                String email = in.nextLine();
                System.out.println("Aggiorna Telefono : ");
                String telefono = in.nextLine();
                System.out.println("Aggiorna Note : ");
                String note = in.nextLine();

                jpAcriteria.modifica(c, nome, cognome, email, telefono, note);


            }

        }
    }


    public void trovaDuplicati() {

        List<Contatto> contattos = jpAcriteria.JPACriteriaLeggiContatti();
        listaContatti = contattos;

        boolean ciSonoDuplicati = false;
        System.out.println(" Ricerca dei duplicati in corso....");


        int i = 0;
        while (i < contattos.size()) {
            Contatto c = contattos.get(i);

            int j = i + 1;
            while (j < contattos.size()) {
                Contatto c1 = contattos.get(j);

                if (c.getEmail().equalsIgnoreCase(c1.getEmail()) && (c.getId() != c1.getId()) && !(c1.getEmail().equals("null")) && !(c1.getEmail().equals(""))) {
                    System.out.println("Duplicato con mail uguale : ");
                    System.out.println(" Contatto 1 " + c.toString());
                    System.out.println(" Contatto 2 " + c1.toString());
                    ciSonoDuplicati = true;
                }
                j++;
            }

            i++;
        }

        i = 0;
        while (i < contattos.size()) {
            Contatto c = contattos.get(i);

            int j = i + 1;
            while (j < contattos.size()) {
                Contatto c1 = contattos.get(j);
                if (c.getTelefono().equalsIgnoreCase(c1.getTelefono()) && (c.getId() != c1.getId()) && !(c1.getTelefono().equals("null")) && !(c1.getTelefono().equals(""))) {
                    System.out.println("Duplicato con stesso numero di telefono : ");
                    System.out.println(" Contatto 1 " + c.toString());
                    System.out.println(" Contatto 2 " + c1.toString());
                    ciSonoDuplicati = true;
                }
                j++;
            }

            i++;
        }

//        for(Contatto c : listaContatti){
//
//            for(Contatto c1 : listaContatti){
//
//                if(c.getEmail().equalsIgnoreCase(c1.getEmail())  && (c.getId()!=c1.getId()) ){
//                    System.out.println("Duplicato trovato in email : ");
//                    System.out.println(" Contatto 1 " +c.toString());
//                    System.out.println(" Contatto 2 " +c1.toString());
//                    ciSonoDuplicati = true;
//                }
//            }
//        }
//
//        for(Contatto c : listaContatti){
//
//            for(Contatto c1 : listaContatti){
//
//                if(c.getTelefono().equals(c1.getTelefono()) && (c.getId()!=c1.getId()) ){
//                    System.out.println("Duplicato trovato in Telefono : ");
//                    System.out.println(" Contatto 1 " +c.toString());
//                    System.out.println(" Contatto 2 " +c1.toString());
//                    ciSonoDuplicati = true;
//                }
//
//
//            }
//        }

        if (ciSonoDuplicati == false) {
            System.out.println("Non ci sono duplicati");
        }
    }

    public void gestisciDuplicati() {

        List<Contatto> contattos = jpAcriteria.JPACriteriaLeggiContatti();
        listaContatti = contattos;
        jpAcriteria = new JPAcriteria();

        boolean ciSonoDuplicati = false;
        System.out.println(" Ricerca dei duplicati in corso....");


        int i = 0;
        while (i < contattos.size()) {
            Contatto c = contattos.get(i);

            int j = i + 1;
            while (j < contattos.size()) {
                Contatto c1 = contattos.get(j);
                if (c.getEmail().equalsIgnoreCase(c1.getEmail()) && (c.getId() != c1.getId()) && !(c1.getEmail().equals("null")) && !(c1.getEmail().equals(""))) {
                    System.out.println("Duplicato tolto per l'email : ");
                    System.out.println(c1.toString());
                    jpAcriteria = new JPAcriteria();
                    jpAcriteria.delete(c1);
                }
                j++;
            }

            i++;
        }

        i = 0;
        while (i < contattos.size()) {
            Contatto c = contattos.get(i);

            int j = i + 1;
            while (j < contattos.size()) {
                Contatto c1 = contattos.get(j);
                if (c.getTelefono().equalsIgnoreCase(c1.getTelefono()) && (c.getId() != c1.getId()) && !(c1.getTelefono().equals("null")) && !(c1.getTelefono().equals(""))) {
                    System.out.println("Duplicato tolto per il numero: ");
                    System.out.println( c1.toString());
                    //jpAcriteria = new JPAcriteria();
                    jpAcriteria.delete(c1);
                }
                j++;
            }

            i++;
        }

    }


    public void importaEsporta() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("1.Importa CSV \n2.Importa XML \n3.Esporta CSV \n4.Esporta XML");

        String scelta = in.next();

        switch (scelta) {

            case "1":
                System.out.println("	                          			    ");
                System.out.println("			    Importa CSV				    ");
                importaCSV();

                break;

            case "2":
                System.out.println("	                       		        	");
                System.out.println("	        	Importa XML		        	");
                importaXML();

                break;
            case "3":
                System.out.println("	                          		    	");
                System.out.println("			    Esporta CSV				    ");
                esportaCSV();

                break;

            case "4":
                System.out.println("	                       		        	");
                System.out.println("	        	Esporta XML		        	");
                writeXML();

                break;
        }


    }

    private void esportaCSV() {
        Scanner in = new Scanner(System.in);
        File file = null;
        FileWriter fileWriter = null;

        System.out.println("Inserisci la directory del file da importare (File Compreso) : ");
        String dir = in.nextLine();
        if(dir.equals("")) {
            System.out.print("directory non valida");
        }else if(checkForPath(dir)){
            System.out.print("\ndirectory già utilizzata\n");
        }else{

            file = new File(dir);
            try
            {
                fileWriter = new FileWriter(file, true);
                fileWriter.append("NOME;COGNOME;EMAIL;TELEFONO;NOTE\n");

                for(Contatto c : listaContatti) {
                    fileWriter.append(""+c.getNome()+";" +c.getCognome()+";" +c.getEmail()+";"+ c.getTelefono()+ ";"+c.getNote()+"\n");
                }

            }
            catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean checkForPath(String path){

        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
            try {
                //file.createNewFile();
                fileReader = new FileReader(path);
                bufferedReader = new BufferedReader(fileReader);
                String riga = bufferedReader.readLine();

                if(riga == null){
                    return false;
                }

            } catch (IOException ioEx) {
                ioEx.printStackTrace();
                System.out.println("Non va;");
            }
        return true;
    }

    private void importaCSV() {

        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci la directory del file da importare (File Compreso) : ");
        String dir = in.nextLine();
        if(dir.equals("")) {
            System.out.print("directory non valida");
        }

        ArrayList<Contatto> contattiImportati = new ArrayList<Contatto>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {

            fileReader = new FileReader(dir);
            bufferedReader = new BufferedReader(fileReader);

            String riga = bufferedReader.readLine();
            // System.out.println(riga);

            while (bufferedReader.ready()) {

                riga = bufferedReader.readLine();
                Contatto contatto = leggiRiga(riga);
                contattiImportati.add(contatto);
                jpAcriteria.JPAaggiungiContatto(contatto);
                System.out.println(" "+contatto.getNome()+ " aggiunto in rubrica");
            }

        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException fEx) {
                fEx.printStackTrace();
            }
        }

        System.out.println("Contatti: " + contattiImportati.size());


    }

    public static Contatto leggiRiga(String riga) {

        String[] columns = riga.split(";");
        String nome, cognome, telefono, email, note;
        Contatto c = new Contatto();

        try {nome = (columns[0]);}
        catch(ArrayIndexOutOfBoundsException e) { nome = ""; }
        c.setNome(nome.trim());

        try {cognome = (columns[1]);}
        catch(ArrayIndexOutOfBoundsException e) { cognome = ""; }
        c.setCognome(cognome.trim());

        try {email = (columns[2]);}
        catch(ArrayIndexOutOfBoundsException e) { email = ""; }
        c.setEmail(email.trim());

        try {telefono = (columns[3]);}
        catch(ArrayIndexOutOfBoundsException e) { telefono = ""; }
        c.setTelefono(telefono.trim());

        try {note = (columns[4]);}
        catch(ArrayIndexOutOfBoundsException e) { note = ""; }
        c.setNote(note.trim());


        return c;
    }

    private void importaXML() {

        Scanner in = new Scanner(System.in);
        System.out.println("Inserisci la directory del file da importare (File Compreso) : ");
        String dir = in.nextLine();
        if (dir.equals("")) {
            System.out.print("directory non valida");
        }

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;

            try {
                    documentBuilder = documentBuilderFactory.newDocumentBuilder();
                    document = documentBuilder.parse(dir);

                    Element root = document.getDocumentElement();
                    NodeList nodes = root.getChildNodes();
                    List<Element> children = getChildElements(root);

			for (Element el : children) {
                Contatto newContatto = new Contatto();
                    if (el.getTagName().equalsIgnoreCase("contatto")) {
                        List<Element> contatto = getChildElements(el);

                    for (Element value : contatto) {

                        switch (value.getTagName().toLowerCase()) {
                            case "nome":
                               // System.out.println("nome : " + value.getTextContent());
                                newContatto.setNome(value.getTextContent());
                               break;
                            case "cognome":
                                //System.out.println("cognome : " + value.getTextContent());
                                newContatto.setCognome(value.getTextContent());
                               break;
                            case "email":
                                //System.out.println("email : " + value.getTextContent());
                                newContatto.setEmail(value.getTextContent());
                               break;
                            case "telefono":
                                //System.out.println("telefono : " + value.getTextContent());
                                newContatto.setTelefono(value.getTextContent());
                                break;
                            case "note":
                                //System.out.println("note : " + value.getTextContent());
                                newContatto.setNote(value.getTextContent());
                                break;

                            default:
                                break;
                        }

                    }
        }
                    jpAcriteria.JPAaggiungiContatto(newContatto);
    }

        } catch (ParserConfigurationException pcEx) {
            pcEx.printStackTrace();
            } catch (IOException ioEx) {
            ioEx.printStackTrace();
                 } catch (SAXException saxEx) {
                saxEx.printStackTrace();
        }

        }
    public static List<Element> getChildElements(Element element) {
        List<Element> childElements = new ArrayList<Element>();
        NodeList nodeList = element.getChildNodes();
        for (int n = 0; n < nodeList.getLength(); n++) {
            if (nodeList.item(n) instanceof Element) childElements.add((Element)nodeList.item(n));
        }

        return childElements;
    }

    public void writeXML() throws Exception {

        Scanner in = new Scanner(System.in);

        System.out.println("Inserisci la directory del file da importare (File Compreso) : ");
        String dir = in.nextLine();
        if(dir.equals("")) {
            System.out.print("directory non valida");
        }

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document doc = documentBuilder.newDocument();

        Element contatti = doc.createElement("contatti");
        doc.appendChild(contatti);//root element

        for(Contatto c : listaContatti){

            {
                Element contatto = doc.createElement("contatto");

                Element cognome = doc.createElement("cognome");
                cognome.setTextContent(c.getCognome());//<cognome>Marrone</cognome>
                contatto.appendChild(cognome);

                Element nome = doc.createElement("nome");
                nome.setTextContent(c.getNome());//<nome>Emma</nome>
                contatto.appendChild(nome);

                Element telefono = doc.createElement("telefono");
                telefono.setTextContent(c.getTelefono());
                contatto.appendChild(telefono);

                Element email = doc.createElement("email");
                email.setTextContent(c.getEmail());
                contatto.appendChild(email);

                Element note = doc.createElement("note");
                note.setTextContent(c.getNote());
                contatto.appendChild(note);

                contatti.appendChild(contatto);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File(dir));

            // Output to console for testing
            StreamResult syso = new StreamResult(System.out);

            transformer.transform(source, result);
            transformer.transform(source, syso);

            System.out.println("File saved!");

        }

    }

}

