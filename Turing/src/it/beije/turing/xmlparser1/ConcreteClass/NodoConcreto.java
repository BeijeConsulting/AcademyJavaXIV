package it.beije.turing.xmlparser1.ConcreteClass;

import java.util.ArrayList;
import java.util.List;

import it.beije.turing.xmlparser1.Interfaces.Nodo;

public class NodoConcreto implements Nodo{
	protected String nodeText;
	
	@Override
	public String toString() {
		return this.nodeText;
	}
	
	public String getNodeText() {
		return nodeText;
	}

	public void setNodeText(String nodeText) {
		this.nodeText = nodeText;
	}

	public NodoConcreto (String nodeText) {
		this.nodeText = nodeText;
	}
	

	public static String getTagName(String text) {
		String tagName = "";
		for (int i = 0; i<text.length(); i++) {
			if (text.charAt(i)=='<') {
				if (text.charAt(i+1)=='/') {
					return null;
				}
				StringBuilder st = new StringBuilder();
				while (text.charAt(i)!='>' & text.charAt(i)!=' ') {
					st.append(text.charAt(i));
					i++;
				}
				tagName=st.toString().substring(1);
				return tagName;	
			}
		}
		return null;
	}
	

	public List<NodoConcreto> getChildNodes() {
//		System.out.println("entering method");
		StringBuilder st = new StringBuilder();
		StringBuilder st2 = new StringBuilder();
		String tagName = "";
		List<NodoConcreto> nodeList = new ArrayList<NodoConcreto>();
		tagName = getTagName(this.nodeText);
		if (tagName==null) {
			nodeList.add(new NodoConcreto(this.nodeText));
			return nodeList;
		}
//		System.out.println("tagname in testa: "+tagName);
//		System.out.println("nodeText in testa: "+nodeText+"*///////");
		st.append(nodeText.trim());
//		System.out.println(st);
		st.delete(0, st.indexOf(">")+1);
//		System.out.println(st);
		if (st.indexOf("</"+tagName+">")!=-1){
			st.delete(st.length()-tagName.length()-3,st.length());
//			System.out.println(st+"//////");
		} else {
			throw new RuntimeException ("illegal formatting");
		}

		String nodeContent = st.toString();
		st = new StringBuilder();
		for (int i = 0; i<nodeContent.length(); i++) {
//			System.out.println("char at for beginning: " + nodeContent.charAt(i));
			st2 = new StringBuilder();
			for (;nodeContent.charAt(i)!='<';i++) {
				st2.append(nodeContent.charAt(i));
//				System.out.println(st2);
				if (i==nodeContent.length()-1) {
					NodoConcreto nWhitespace = new NodoConcreto(st2.toString());
					nodeList.add(nWhitespace);
//					System.out.println("nodelist length "+nodeList.size());
					return nodeList;
				} 

				if(nodeContent.charAt(i+1)=='<') {
					NodoConcreto nWhitespace = new NodoConcreto(st2.toString());
					nodeList.add(nWhitespace);
//					System.out.println("nodelist length "+nodeList.size());
					st.append(st2);

				}
			}
			if(nodeContent.charAt(i)=='<') {
				String newText = nodeContent.substring(i);
				String subTagName = getTagName(newText);
//				System.out.println("subTagName: "+subTagName);
//				System.out.println("newText: "+newText);
				
				if (newText.charAt(newText.substring(1).indexOf('>'))=='/') {
					
					String oneLiner = newText.substring(0,newText.indexOf('>')+1);
//					System.out.println("entered if, create node : "+ oneLiner);
					nodeList.add(new ElementoConcreto(oneLiner));
					st.append(oneLiner);
//					System.out.println(i);
					i+=oneLiner.length()-1;
//					System.out.println(i);
					continue;
				}
	//			if (newText.substring(newText.indexOf('>')).indexOf("<"+subTagName)!=-1 
	//					&& newText.substring(newText.indexOf('>')).indexOf("<"+subTagName)!=-1){
	//				System.out.println("if");
	//				n = new NodoConcreto(newText.substring(0,newText.indexOf("</"+subTagName , newText.indexOf("</"+subTagName)+1)+3+subTagName.length()));
	//			} else {
	//				System.out.println("else");
				NodoConcreto n = new NodoConcreto(newText.substring(0,newText.indexOf("</"+subTagName+'>')+3+subTagName.length()));
	//			}
				StringBuilder nextLayer = new StringBuilder();
				List<NodoConcreto> childList = n.getChildNodes();
				for (NodoConcreto nc:childList) {
					nextLayer.append(nc.getNodeText());
				}
	//			System.out.println("nodeText in zona creazione nodo: "+nodeContent+"///////");
				//				System.out.println("nodeText substring: "+nodeText.substring(i,i+9)+"///////");
				String header = nodeContent.substring(i,nodeContent.indexOf('>',i)+1);
				String childTag = getTagName(header);
				String result = header+nextLayer+"</"+childTag+">";
				st.append(result);
				nodeList.add(new ElementoConcreto(result));
	//			System.out.println("Nodes: "+nodeList.size()+" next layer added st:" +st+"////////");
				i+=result.length()-1;
			}
		}
		return nodeList;
	}

	@Override
	public String getTestoCompleto() {
		return nodeText;
	}
}
