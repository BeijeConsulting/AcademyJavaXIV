package it.beije.turing.xmlparser4;

import java.util.List;

public class DocXml {

    Node root=null;

    public Node getRootElement() {
        return root;
    }
    
    private DocXml(Node root)
    {
    	this.root=root;
    }
    
    
    public static DocXml parse(String fileName)
    {
    	FileParser fp = new FileParser();
		List<String> list=fp.parseFile(fileName);
		XMLinterpreter tool = new XMLinterpreter(list);
		tool.print();
		try {
			return new DocXml(tool.ParseRoot());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

}
