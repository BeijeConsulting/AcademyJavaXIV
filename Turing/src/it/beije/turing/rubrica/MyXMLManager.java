package it.beije.turing.rubrica;

import it.beije.turing.file.XMLmanager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyXMLManager {

    public List<Contatto> loadRubricaFromXML(String pathFile) {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;
        List<Contatto> contacts = null;

        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(pathFile);
            contacts = new ArrayList<>();

            Element root = document.getDocumentElement();

            List<Element> children = XMLmanager.getChildElements(root);

            for (Element el : children) {
                if (el.getTagName().equalsIgnoreCase("contatto")) {
                    Contatto contact = new Contatto();
                    List<Element> contatto = XMLmanager.getChildElements(el);
                    for (Element field : contatto) {
                        switch (field.getTagName().toLowerCase()) {
                            case "cognome": {
                                contact.setCognome(field.getTextContent());
                                break;
                            }
                            case "nome": {
                                contact.setNome(field.getTextContent());
                                break;
                            }
                            case "telefono": {
                                contact.setTelefono(field.getTextContent());
                                break;
                            }
                            case "email": {
                                contact.setEmail(field.getTextContent());
                                break;
                            }
                            case "note": {
                                contact.setNote(field.getTextContent());
                                break;
                            }
                            default:
                                throw new IllegalArgumentException("Unexpected value: " + field.getTagName().toLowerCase());
                        }
                    }

                    contacts.add(contact);
                }
            }

        } catch (ParserConfigurationException pcEx) {
            pcEx.printStackTrace();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } catch (SAXException saxEx) {
            saxEx.printStackTrace();
        }

        return contacts;
    }

    public void writeRubricaXML(List<Contatto> contacts, String pathFile) {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {

            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.newDocument();

            Element wrapper = doc.createElement("rubrica");
            doc.appendChild(wrapper);

            for (Contatto contact : contacts) {
                Element el = doc.createElement("contatto");

                if (contact.getCognome() != null) {
                    Element cognome = doc.createElement("cognome");
                    cognome.setTextContent(contact.getCognome());
                    el.appendChild(cognome);
                }
                if (contact.getNome() != null) {
                    Element nome = doc.createElement("nome");
                    nome.setTextContent(contact.getNome());
                    el.appendChild(nome);
                }
                if (contact.getEmail() != null) {
                    Element email = doc.createElement("email");
                    email.setTextContent(contact.getEmail());
                    el.appendChild(email);
                }
                if (contact.getTelefono() != null) {
                    Element telefono = doc.createElement("telefono");
                    telefono.setTextContent(contact.getTelefono());
                    el.appendChild(telefono);
                }
                if (contact.getNote() != null) {
                    Element note = doc.createElement("note");
                    note.setTextContent(contact.getNote());
                    el.appendChild(note);
                }

                wrapper.appendChild(el);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);

                StreamResult result = new StreamResult(new File(pathFile));

                StreamResult syso = new StreamResult(System.out);

                transformer.transform(source, result);
                transformer.transform(source, syso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
