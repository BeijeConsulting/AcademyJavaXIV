package it.beije.turing.file;

import it.beije.turing.rubrica.Contatto;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadFile {
    int i = 0;

    public static void main(String[] args) {
//		List<Contatto> contatti = loadRubricaFromCSV("/Users/simonepitossi/File/newContatti.csv", ";");
//		for (Contatto c: contatti) {
//			System.out.println(c.toString());
//		}
        ReadFile f = new ReadFile();
        System.out.println(f.i);
        int[] s = new int[2];
        System.out.println("java" + new StringBuilder("java"));
        //	loadRubricaFromXML("/Users/simonepitossi/File/SottoFile/SottoSottoFile/xml.xml");

    }

    public static void readFileList(File[] fL) {
        for (File f : fL) {
            if (f.isFile() && !f.getName().equalsIgnoreCase(".DS_Store")) {
                System.out.println(f.getName() + "\n");
                readFile(f);
            } else if (f.isDirectory()) {
                readFileList(f.listFiles());
                Date date = new Date();
                ;
            }
        }
    }

    public static void readFile(File file) {
        FileReader fileReader = null;
        BufferedReader bufferReader = null;

        try {
            fileReader = new FileReader(file);
            bufferReader = new BufferedReader(fileReader);

            while (bufferReader.ready()) {
                System.out.println(bufferReader.readLine() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                bufferReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {
        List<Contatto> contatti = new ArrayList<>();
        ArrayList<String> s = new ArrayList<>();
        File file = new File(pathFile);
        FileReader fileReader = null;
        BufferedReader bufferReader = null;
        boolean primaLinea = true;

        try {
            fileReader = new FileReader(file);
            bufferReader = new BufferedReader(fileReader);

            while (bufferReader.ready()) {
                String riga = bufferReader.readLine();
                String[] campiStringa = riga.split(separator);

                if (primaLinea) {
                    primaLinea = false;
                    individuaColonneCSV(s, campiStringa);
                    separator = csvContieneVirgolette(riga, separator);
                } else {
                    contatti.add(Contatto.creaContatto(s, campiStringa));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return contatti;
    }

    public static void individuaColonneCSV(ArrayList<String> s, String[] individuaCampi) {
        for (String stringa : individuaCampi) {
            switch (stringa.toLowerCase()) {
                case "nome":
                    s.add("nome");
                    break;
                case "cognome":
                    s.add("cognome");
                    break;
                case "telefono":
                    s.add("telefono");
                    break;
                case "email":
                    s.add("email");
                    break;
                case "note":
                    s.add("note");
                    break;
                default:
                    break;
            }
        }
    }

    public static String csvContieneVirgolette(String campi, String separator) {
        boolean campiTraVirgolette = false;
        String[] individuaCampi = campi.split(separator);

        switch (individuaCampi[0].toLowerCase()) {
            case "\"nome\"":
                campiTraVirgolette = true;
            case "\"cognome\"":
                campiTraVirgolette = true;
            case "\"telefono\"":
                campiTraVirgolette = true;
            case "\"email\"":
                campiTraVirgolette = true;
            case "\"note\"":
                campiTraVirgolette = true;
            default:
                break;
        }

        if (campiTraVirgolette) {
            return "\"" + separator + "\"";
        } else {
            return separator;
        }
    }

    public static List<Contatto> loadRubricaFromXML(String pathFile) {
        List<Contatto> contattoList = new ArrayList<>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;

        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(pathFile);
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Element element = document.getDocumentElement();
            System.out.println(element.getTagName());
            List<Element> elements = elementsInChildNodes(element);

            for (Element ele : elements) {
                System.out.println(ele.getTagName());
                printChildren(ele, 0, contattoList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contattoList;
    }

    public static void printChildren(Element element, int count, List<Contatto> contattoList) {
        List<Element> el = elementsInChildNodes(element);
        Contatto contatto = new Contatto();

        for (Element e : el) {
            for (int i = 0; i < count; i++) {
                System.out.print("\t");
            }

            switch (e.getTagName().toLowerCase()) {

                case "nome":
                    System.out.println("Nome : " + e.getTextContent());
                    contatto.setNome(e.getTextContent());
                    break;
                case "cognome":
                    System.out.println("Cognome : " + e.getTextContent());
                    contatto.setCognome(e.getTextContent());
                    break;
                case "telefono":
                    System.out.println("Telefono : " + e.getTextContent());
                    contatto.setTelefono(e.getTextContent());
                    break;
                case "email":
                    System.out.println("Email : " + e.getTextContent());
                    contatto.setEmail(e.getTextContent());
                    break;
                case "note":
                    System.out.println("Note : " + e.getTextContent());
                    contatto.setNote(e.getTextContent());
                    break;
                case "contatto":
                    count += 1;
                    printChildren(e, count, contattoList);
                    break;
                default:
                    break;
            }
        }
            contattoList.add(contatto);
    }

    private static List<Element> elementsInChildNodes(Element element) {
        List<Element> elements = new ArrayList<>();
        NodeList nodeList = element.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                elements.add((Element) node);
            }
        }

        return elements;
    }

}
