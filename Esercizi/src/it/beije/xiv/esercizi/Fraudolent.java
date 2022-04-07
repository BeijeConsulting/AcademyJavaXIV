package it.beije.xiv.esercizi;

import java.io.*;
import java.util.ArrayList;

public class Fraudolent {
	
	FileReader file;
	BufferedReader buffered;
	ArrayList<String> operations = new ArrayList<>();
	double sellSum;
	double buySum;
	int operationNumber;
	
	public Fraudolent(String fileName) throws IOException {
		String filePath = new File("").getAbsolutePath();
		filePath = filePath.concat(fileName);
		setFile(filePath);
	}
	
	public void setFile(String filePath) throws IOException {
		file = new FileReader(filePath);
		buffered = new BufferedReader(file);
		readFile();
	}
	
	public void readFile() throws IOException {
		while(true) {
			String s = new String();
			s = buffered.readLine();
		    if(s == null) break;
		    addOperations(s);
//		    System.out.println(s);
		}
	}
	
	public void addOperations(String s) {
		operations.add(s);
	}
	
	public void calcOperation() {
		for(String s : operations) {
			String[] parts = s.split(" ");
			double cost = Double.parseDouble(parts[1]);
			int quantity = Integer.parseInt(parts[2]);
			double totalCost = cost * quantity;
			if(parts[3].equalsIgnoreCase("B")) buySum += totalCost;
			else sellSum += totalCost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		Fraudolent bank = new Fraudolent("/src/it/beije/xiv/esercizi/Fraudolent.txt");
		
		bank.operationNumber = bank.operations.size();
		bank.calcOperation();
		
		System.out.println("Op: " + bank.operationNumber + " Buy: " + bank.buySum + " Sell: " + bank.sellSum);
		

	}

}
