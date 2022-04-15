package it.beije.turing.xmlparser5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class DocumentoXML {
	
	private String stringaFile;
	
	public String getStringaFile() {
		return stringaFile;
	}

	public void setStringaFile(String stringaFile) {
		this.stringaFile = stringaFile;
	}
	

//	getChildNodes() //torna tutti i nodi "figli" interni all'elemento su cui viene eseguito
////	getChildElements() //torna i soli elementi figli dell'elemento su cui viene eseguito
//	getElementsByTagName(String tagName) //torna TUTTI gli elementi con quello specifico nome
////	getTagName() //torna il nome del tag
////	getTextContent() //torna il contenuto del tag
////	getAttributes() //torna l'elenco degli attributi dell'elemento
//	getAttribute(String attribute) //torna il valore dell'attributo specificato

	


	public List<String> getElementsByTagName(String tagName , String rootEle){
		List<String> lista = new ArrayList<String>();
		StringBuilder root = new StringBuilder(rootEle);
		while(root.toString().contains(tagName)) {
			String inizio = "<" + tagName;
			String fine = "</"+tagName;
			int index = root.indexOf("<" + tagName);
			getElementsByTagName(tagName, root.substring(index + inizio.length() , root.length()));
			String s = root.substring(root.indexOf("<"+tagName), root.indexOf("</"+tagName) + fine.length()+1);

			lista.add(s);
			root.delete(root.indexOf("<"+tagName), root.indexOf(fine) + fine.length()+1);
		}
		return lista;
	}




	//rimuove l intestazione del XML eventualmente esiste
	
	
	public Tag getNodeChild() {
		String rootStringa = removeDeclarationTag();
		String nome = getTagNameFromString(rootStringa).trim();
		String textContent = getTextContentString(rootStringa);
		
		List<String> childrenStringa = getChildElements(textContent);
		
		Tag root = new Tag(nome, textContent);
		
		
		for (String child : childrenStringa) {
			String tagName = getTagNameFromString(child);
			String tagContent = getTextContentString(child);
			Tag tagFiglio = new Tag(tagName, tagContent);
			root.addTag(tagFiglio);
		}
		return root;
	}
	
	public List<String> getAttributeFromString(String text) {
		List<String> attrs = new ArrayList<>();
		if (text.length() > 0) {
			String tagName = getTagNameFromString(text);
			int firstSpacebar = text.indexOf(" ");
			if (tagName == null) return null;
			if (firstSpacebar == -1) return null;
			int indexOfTagName = text.indexOf(tagName);
			int closingTag = text.indexOf(">", indexOfTagName);
			if (firstSpacebar > closingTag) return null;
			else {
				int startAttr = firstSpacebar + 1;
				
				while ((firstSpacebar != -1) && (firstSpacebar < closingTag)) {
					String attr = new String();
					int startAttrValue = text.indexOf("=", firstSpacebar) + 2;
					int endAttr = text.indexOf("\"", startAttrValue) + 1;
					
					attr = text.substring(startAttr, endAttr);
					System.out.println("ATTRIBUTO:"+attr);
					attrs.add(attr);
					
					firstSpacebar = text.indexOf(" ", endAttr);
					startAttr = firstSpacebar + 1;
				}
				
				return attrs;
			}
		}
		
		return null;
		
	}
	
	public String getAttributeValueFromString(String attr) {
		String value = null;
		int beginValue = attr.indexOf("=") + 2;
		if (beginValue > 0) {
			int endValue = attr.length() - 1;
			value = attr.substring(beginValue, endValue);
		}
		
		return value;
	}
	
	public String getAttributeNameFromString(String attr) {
		String name = null;
		int endName = attr.indexOf("=");
		if (endName != -1)
			name = attr.substring(0, endName);
		
		return name;
	}

	public String getTextContentString(String el){
		int indexBegin = el.indexOf("<", el.indexOf(">"));
		int indexEnd = el.lastIndexOf("<");
		if (indexBegin == indexEnd) {
			indexBegin = el.indexOf(">") + 1;
		}
		String textContent = el.substring(indexBegin, indexEnd);
		return textContent;
	}
	
	public List<String> getChildElements(String textContent) {
        List<String> children = new ArrayList<>();
        String tagName = getTagNameFromString(textContent);


        while ((tagName != null) && textContent.contains(tagName)) {
            String closureTag = "/" + tagName + ">";
            int indexBegin = textContent.indexOf("<");
            int startClosure = textContent.indexOf(closureTag);
            int endClosure = startClosure + closureTag.length();

            String child = textContent.substring(indexBegin, endClosure);

            int cutContentFrom = textContent.indexOf("<", startClosure);
            if (cutContentFrom != -1) {
                textContent = textContent.substring(cutContentFrom);
                tagName = getTagNameFromString(textContent);
            } else {
                textContent = "";
            }

            children.add(child);
        }


        return children;
    }
	
	public int getIndexOfChild(String el , String c) { 
		int index = el.indexOf(c , el.indexOf(">"));
		return index;
	}
	
	public String getTagNameFromString(String el) {
		String tagName = new String();
		if (el.length() > 0) {
			
			int firstSpacebar = el.indexOf(" ");
			int startIndex = el.indexOf("<") + 1;
			int closingTag = el.indexOf(">");
			if (closingTag == -1 ) {
				return null;
			}
			if (firstSpacebar == -1) {
				tagName = el.substring(startIndex, closingTag);
			} else if(firstSpacebar > closingTag){
				tagName = el.substring(startIndex, closingTag);
			} else {
				tagName = el.substring(startIndex, firstSpacebar);
			}
			return tagName;
		}
		
		return null;
		
	}
	
	//--------------------------------------------CONCLUSO CHE FUNZIONA------------------------------------
	
	public Tag getRootElement() {
		String rootStringa = removeDeclarationTag();
		String nome = getTagNameFromString(rootStringa).trim(); // ritorna "contatti"
		String textContent = getTextContentString(rootStringa); // ritorna tutto il contenuto del tag contatti
		
		Tag root = new Tag(nome, textContent);
		
		List<String> childrenStringa = getChildElements(textContent);
		
		for (String child : childrenStringa) {
			List<String> attributeString = getAttributeFromString(child);
			String tagName = getTagNameFromString(child);
			String tagContent = getTextContentString(child);
			Tag tagFiglio = new Tag(tagName, tagContent);
			
			
			for (String attr : attributeString) {
				String nomeAttr = getAttributeNameFromString(attr);
				String valueAttr = getAttributeValueFromString(attr);
				Attributo attributo = new Attributo(nomeAttr, valueAttr);
				tagFiglio.addAttributo(attributo);
			}
			
			root.addTag(tagFiglio);
		}
		return root;
	}
	
	public Tag buildDoc(Tag tag) {
		List<Tag> children = tag.getChildren();
		
		for (Tag child : children) {
			List<String> childrenString = getChildElements(child.getContenuto());
			
			for (String childString : childrenString) {
				List<String> attributeString = getAttributeFromString(childString);
				String tagName = getTagNameFromString(childString);
				String tagContent = getTextContentString(childString);
				Tag tagFiglio = new Tag(tagName, tagContent);
				
				if (attributeString != null) {
					for (String attr : attributeString) {
						String nomeAttr = getAttributeNameFromString(attr);
						String valueAttr = getAttributeValueFromString(attr);
						Attributo attributo = new Attributo(nomeAttr, valueAttr);
						tagFiglio.addAttributo(attributo);
					}
				}
				
				child.addTag(tagFiglio);
			}
			
			buildDoc(child);
		}
		return tag;
	}

	public String getContenutoFile(String path) {
		StringBuilder s = new StringBuilder();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			while (br.ready()) {
				s.append((char) br.read());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return s.toString();
	}

	public String removeDeclarationTag() {
		String s = this.stringaFile;
		String senzaIntestazione = null;
		if(s.startsWith("<?") && s.contains("?>")) {
			senzaIntestazione = s.substring(s.indexOf("?>") + 2);
		}
		if(senzaIntestazione != null) {
			return senzaIntestazione;
		}
		return s;
		
	}

}
