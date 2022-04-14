package it.beije.turing.xmlparser4;

import java.util.List;

/**
 * 
 * @author Sancesario Giuseppe, Frontini Luca
 *
 */
public class XMLParser4 {

	public static void main(String[] args) 
	{
		FileParser fp = new FileParser();
		List<String> list=fp.parseFile("C:\\Users\\39346\\IdeaProjects\\AcademyJavaXIV\\Turing\\tmp\\test_parser1.xml");
		XMLinterpreter xml = new XMLinterpreter(list);
		xml.Test();
	}

}
