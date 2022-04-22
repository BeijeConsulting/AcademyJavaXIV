package it.beije.turing.myRubrica.interfaces;

import it.beije.turing.rubrica.Contatto;
import org.w3c.dom.*;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


/**
 * @author Giuseppe Raddato
 * Data: 19 apr 2022
 */
public interface OpRubrica {
    public List<Contatto> showContact(Order order);
    public List<Contatto> search(String s);
    public boolean insert(Contatto c);
    public boolean modificaContatto(Contatto c);
    public boolean deleteContatto(Contatto c);
    public List<Contatto> contattiDuplicati();
    public void unisciContatti();
    public List<Contatto> importFromCVS(String path, String separator);
    public List<Contatto> importFromXML(String path);
    public void exportFromCVS(String path,List<Contatto> contats, String separator);
    public void exportFromXML(String path,List<Contatto> contatti);



    public static void exportFileXML(String path,List<Contatto> contats){
        DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        Document document;
        try {
             documentBuilder=documentBuilderFactory.newDocumentBuilder();
             document=documentBuilder.newDocument();
            Element contatti=document.createElement("contatti");

            for (Contatto c:contats) {
                Element contatto= document.createElement("contatto");

                Element nome= document.createElement("nome");
                nome.setTextContent(c.getNome());
                contatto.appendChild(nome);

                Element cognome= document.createElement("cognome");
                cognome.setTextContent(c.getCognome());
                contatto.appendChild(cognome);

                Element mail= document.createElement("email");
                mail.setTextContent(c.getEmail());
                contatto.appendChild(mail);


                Element telefono= document.createElement("telefono");
                telefono.setTextContent(c.getTelefono());
                contatto.appendChild(telefono);

                Element note= document.createElement("note");
                note.setTextContent(c.getNote());
                contatto.appendChild(note);
                contatti.appendChild(contatto);
            }
            document.appendChild(contatti);

            Transformer transformer= TransformerFactory.newInstance().newTransformer();
            DOMSource source= new DOMSource(document);

            StreamResult result=new StreamResult(new File(path));
            transformer.transform(source,result);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
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
    public static List<Contatto> impotFileXML(String path){
        List<Contatto> contattos= new ArrayList<>();
        DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        Document document;
        try {
           documentBuilder = documentBuilderFactory.newDocumentBuilder();
           document=documentBuilder.parse(path);

           Element root=document.getDocumentElement();
           List<Element> children = getChildElements(root);

            for (Element el : children) {
                if (el.getTagName().equalsIgnoreCase("contatto")) {
                    List<Element> contatto = getChildElements(el);
                    Contatto c= new Contatto();
                    for (Element value : contatto) {
                        switch (value.getTagName().toLowerCase()) {
                            case "nome":
                                c.setNome(value.getTextContent());
                                break;
                            case "cognome":
                                c.setCognome(value.getTextContent());
                                break;
                            case "telefono":
                                c.setTelefono(value.getTextContent());
                                break;
                            case "email":
                                c.setEmail(value.getTextContent());
                                break;
                            case "note":
                                c.setNote(value.getTextContent());
                                break;
                            default:
                                break;
                        }
                    }
                    contattos.add(c);
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return contattos;
    }
    public static void exportFileCVS(String path,List<Contatto> contats, String separator){
        if(separator.length()!=1) throw new RuntimeException("Separator not valid: max length 1");


        File file = new File(path);
        FileWriter fileWriter=null;


        try {
            fileWriter= new FileWriter(file);

            fileWriter.write("NOME"+separator+"COGNOME"+separator+"EMAIL"+separator+"TELEFONO"+separator+"NOTE\n");

            for (Contatto c:contats ){
                fileWriter.write(c.getNome());
                fileWriter.write(separator);
                fileWriter.write(c.getCognome());
                fileWriter.write(separator);
                fileWriter.write(c.getEmail());
                fileWriter.write(separator);
                fileWriter.write(c.getTelefono());
                fileWriter.write(separator);
                fileWriter.write(c.getNote());
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static List<Contatto> importFileCVS(String path, String separator){
        if(separator.length()!=1) throw new RuntimeException("Separator not valid");


        List<Contatto> list= new ArrayList<>();
        FileReader fReader=null;
        BufferedReader bReader=null;


        try {
            fReader= new FileReader(path);
            bReader= new BufferedReader(fReader);
            boolean firstLine=true;

            HashMap<Integer, String> index= new HashMap<>();
            while (bReader.ready()){
                String r= bReader.readLine();
                String[] params=r.split(separator);
                Contatto contatto = new Contatto();
                if(firstLine){
                    firstLine=false;
                    if(params.length==1){
                        throw new RuntimeException("File or Separator not valid");
                    }

                    for (int i = 0; i < params.length; i++) {
                        index.put(i,params[i]); //salvo gli indici di ogni elemento
                    }


                }else{
                    for (int i = 0; i < params.length; i++) {
                        if(index.get(i).equalsIgnoreCase("nome")){
                            contatto.setNome(params[i]);
                        } else   if(index.get(i).equalsIgnoreCase("cognome")){
                            contatto.setCognome(params[i]);
                        }else   if(index.get(i).equalsIgnoreCase("email")){
                            contatto.setEmail(params[i]);
                        }else   if(index.get(i).equalsIgnoreCase("telefono")){
                            contatto.setTelefono(params[i]);
                        }else   if(index.get(i).equalsIgnoreCase("note")){
                            contatto.setNote(params[i]);
                        }
                    }
                    list.add(contatto);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (PatternSyntaxException e) {
            e.printStackTrace();
        }finally {
            try {
                bReader.close();
                fReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
