package it.beije.xiv.esercizi;

import java.io.File;  
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; 


public class Fraudolent {
	public static void main(String[]args) throws FileNotFoundException{
		Fraudolent f = new Fraudolent();
		String path = "C:\\Users\\aless_in4zoow\\"
				+ "Documents\\GitHub\\AcademyJavaXIV\\Esercizi\\"
				+ "src\\it\\beije\\xiv\\esercizi\\File\\fraudolent.txt";
	    ArrayList<String> a = new ArrayList<String>();
	    ArrayList<String> b = new ArrayList<String>();
	    f.readFile(path,a);
	    System.out.println(a);
	    String res = f.fraudolentCount(a,b);
	    System.out.print(res);
	    if(b.size()>0) {
	    	System.out.println("Err: "+b.size());
		    for(int i=0;i<b.size();i++) {
		    	System.out.println(b.get(i));
		    }
	    }
	    
	    
	    
	      
	}
	void readFile(String path, ArrayList<String> a) throws FileNotFoundException {
		File myObj = new File(path);
	    Scanner myReader = new Scanner(myObj);
	    while (myReader.hasNextLine()) {
	    	String data = myReader.nextLine();
	        a.add(data);
	    }
	    myReader.close();
	}
	
	String fraudolentCount(ArrayList<String> a,ArrayList<String> b) {
		String res = new String();
		int op = a.size();
		double buyImp = 0;
		double sellImp = 0;
		for(int i=0; i<a.size();i++) {
			if(a.get(i).charAt(13)=='B') {
				String azione = a.get(i).substring(4, 8);
				String quantita = a.get(i).substring(9,12);
				buyImp += (Double.parseDouble(azione)*Double.parseDouble(quantita));
			}
			else if(a.get(i).charAt(13)=='S') {
				String azione = a.get(i).substring(4, 8);
				String quantita = a.get(i).substring(9,12);
				sellImp += (Double.parseDouble(azione)*Double.parseDouble(quantita));
			}
			else {
				b.add(a.get(i));
			}
		}
		
		res = "Op: "+op+", Buy: "+buyImp+", Sell:"+sellImp+"\n";
		
		return res;
	}
}
