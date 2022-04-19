package it.beije.turing.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import it.beije.turing.file.CSVreader;
import it.beije.turing.file.XMLmanager;
import it.beije.turing.rubrica.Contatto;
public class EsRubrica {

    public List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        List<Contatto> contatti = null;
        try {
            fileReader = new FileReader(pathFile);

            bufferedReader = new BufferedReader(fileReader);
            int c = 0;
            contatti = new ArrayList<Contatto>();
            Contatto contatto = null;
            while (bufferedReader.ready()) {
                String row = bufferedReader.readLine();
                //System.out.println(++c + " " + row);
                c++;
                row = row.substring(0, row.length());
                //System.out.println(c + " " + row);
                //System.out.println(c + " " + row.length());
                String[] columns = row.split(separator);
                //System.out.println("lunghezza riga "+c+": "+columns.length);
                //for (String col : columns) System.out.println(col);

                if(row.endsWith(";;;")){
                    if(c>1) {

                        contatto = new Contatto();
                        contatto.setCognome(null);
                        contatto.setNome(null);
                        contatto.setEmail(null);
                        contatto.setTelefono(null);
                        //contatto.setNote(columns[4]);

                        //System.out.println(contatto);
                        contatti.add(contatto);
                    }
                }else if(row.endsWith(";;")){
                    if(c>1) {

                        contatto = new Contatto();
                        contatto.setCognome(columns[0]);
                        contatto.setNome(columns[1]);
                        contatto.setEmail(null);
                        contatto.setTelefono(null);
                        //contatto.setNote(columns[4]);

                        //System.out.println(contatto);
                        contatti.add(contatto);
                    }

                }else if(row.endsWith(";")){
                    if(c>1) {

                        contatto = new Contatto();
                        contatto.setCognome(columns[0]);
                        contatto.setNome(columns[1]);
                        contatto.setEmail(columns[2]);
                        contatto.setTelefono(null);
                        //contatto.setNote(columns[4]);

                        //System.out.println(contatto);
                        contatti.add(contatto);
                    }
                }else {
                    if(c>1) {
                        contatto = new Contatto();
                        contatto.setCognome(columns[0]);
                        contatto.setNome(columns[1]);
                        contatto.setEmail(columns[2]);
                        contatto.setTelefono(columns[3]);
                        //contatto.setNote(columns[4]);

                        //System.out.println(contatto);
                        contatti.add(contatto);
                    }
                }
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
        return contatti;

    }

    public List<Contatto> loadRubricaFromXML(String pathFile) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;
        List<Contatto> contatti = null;
        XMLmanager x = new XMLmanager();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(pathFile);
            contatti = new ArrayList<Contatto>();
            Element root = document.getDocumentElement();
            //System.out.println("root : " + root.getTagName());

            NodeList nodes = root.getChildNodes();
            //System.out.println("nodes num : " + nodes.getLength());

            List<Element> children = x.getChildElements(root);
            //System.out.println("children num : " + children.size());

            for (Element el : children) {

                if (el.getTagName().equalsIgnoreCase("contatto")) {
                    List<Element> contatto = x.getChildElements(el);
                    Contatto c = new Contatto();
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
                                contatti.add(c);
                                break;

                            default:
                                break;
                        }


                    }
                }

            }

        } catch (ParserConfigurationException pcEx) {
            pcEx.printStackTrace();
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } catch (SAXException saxEx) {
            saxEx.printStackTrace();
        }
        return contatti;
    }

    public void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator) {
        File file = new File(pathFile);
        System.out.println("file exists? " + file.exists());

        if (file.exists()) {
            System.out.println("FILE GIA' ESISTENTE!!!");
//			return;
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);

//			// "NOME","COGNOME","TELEFONO","EMAIL","NOTE"
//			fileWriter.write("\"NOME\",\"COGNOME\",\"TELEFONO\",\"EMAIL\",\"NOTE\"");
//			fileWriter.write('\n');
//			//"Mario";"Rossi";"3432532555";"mario.rossi@gmail.com";"vicino di casa"
//			fileWriter.write("\"Mario\";\"Rossi\";\"00000000\";\"mario.rossi@gmail.com\";\"vicino di casa\"");

            contatti = loadRubricaFromCSV("/temp/rubrica.csv",separator);
            for (Contatto contatto : contatti) {
//				fileWriter.write(row);
                if(contatto.getCognome()!=null) {
                    fileWriter.write(contatto.getCognome());
                    fileWriter.write(separator);
                }else {
                    fileWriter.write("");
                    fileWriter.write(separator);
                }

                if(contatto.getNome()!=null) {
                    fileWriter.write(contatto.getNome());
                    fileWriter.write(separator);
                }else {
                    fileWriter.write("");
                    fileWriter.write(separator);
                }

                if(contatto.getEmail()!=null) {
                    fileWriter.write(contatto.getEmail());
                    fileWriter.write(separator);
                }else {
                    fileWriter.write("");
                    fileWriter.write(separator);
                }

                if(contatto.getTelefono()!=null) {
                    fileWriter.write(contatto.getTelefono());
                    //fileWriter.write(separator);
                }else {
                    fileWriter.write("");
                    //fileWriter.write(separator);
                }
				/*
				if(contatto.getNote()!=null) {
					fileWriter.write(contatto.getNote());

				}else {
					fileWriter.write("");

				}
				*/
                fileWriter.write("\n");
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException fEx) {
                fEx.printStackTrace();
            }

            System.out.println("done");
        }
    }
    //
    public void writeRubricaXML(List<Contatto> contatti, String pathFile) throws Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document doc = documentBuilder.newDocument();

        Element rubrica = doc.createElement("rubrica");
        doc.appendChild(rubrica);//root element

        for(Contatto cont: contatti) {
            Element contatto = doc.createElement("contatto");

            Element cognome = doc.createElement("cognome");
            cognome.setTextContent(cont.getCognome());//<cognome>Marrone</cognome>
            contatto.appendChild(cognome);

            Element nome = doc.createElement("nome");
            nome.setTextContent(cont.getNome());//<nome>Emma</nome>
            contatto.appendChild(nome);

            Element telefono = doc.createElement("telefono");
            telefono.setTextContent(cont.getTelefono());
            contatto.appendChild(telefono);

            Element email = doc.createElement("email");
            email.setTextContent(cont.getEmail());
            contatto.appendChild(email);
	/*
			Element note = doc.createElement("note");
			note.setTextContent(cont.getNote());
			contatto.appendChild(note);
	*/
            rubrica.appendChild(contatto);
        }
        System.out.println("contatti : " + rubrica.getElementsByTagName("rubrica").getLength());

        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(new File(pathFile));

        // Output to console for testing
        StreamResult syso = new StreamResult(System.out);

        transformer.transform(source, result);
        transformer.transform(source, syso);

        //System.out.println("File saved!");
    }


    public static void main(String[] args) throws Exception {
        EsRubrica es = new EsRubrica();
        // First exercise
        List<Contatto> contatti= es.loadRubricaFromCSV("/temp/rubrica.csv",";");
        for(Contatto contatto : contatti) System.out.println(contatto);
        System.out.println("contatti: "+contatti.size());

        // Second excercise
        List<Contatto> contatti1= es.loadRubricaFromXML("/temp/new_rubrica.xml");
        for(Contatto contatto : contatti1) System.out.println(contatto);

        // Third excercise
        es.writeRubricaCSV(contatti, "/temp/rubricaCSV.csv", ";");

        // Fourth excercise
        es.writeRubricaXML(contatti1, "/temp/rubricaXML.xml" );
    }

}
