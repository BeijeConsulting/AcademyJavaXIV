package it.beije.turing.rubrica;

public class RubricaInterpreteCSV {
	int[] ordine = {-1,-1,-1,-1,-1};
	boolean apici,prepared = false;
	
	public  RubricaInterpreteCSV(String s, boolean b)
	{
		apici = b;
		String[] intest=prepareString(s,b);
		
		int position = 0;
		for(String i : intest)
		{
			switch(i)
			{
			case "NOME": ordine[0]=position;break;
			case "COGNOME": ordine[1]=position;break;
			case "TELEFONO":ordine[2]=position;break;
			case "EMAIL":ordine[3]=position;break;
			case "NOTE" :ordine[4]=position;break;
			}
			position++;
		}
		prepared = true;
	}
	public Contatto interpreta(String s)
	{
		if(prepared) {
		String toRead[]= prepareString(s,apici);
		Contatto contatto = new Contatto();
		if(ordine[0]!=-1){
		contatto.setNome(toRead[ordine[0]]);
		}
		if(ordine[1]!=-1){
		contatto.setCognome(toRead[ordine[1]]);
		}
		if(ordine[2]!=-1){
		contatto.setTelefono(toRead[ordine[2]]);
		}
		if(ordine[3]!=-1){
		contatto.setEmail(toRead[ordine[3]]);
		}
		if(ordine[4]!=-1){
		contatto.setNote(toRead[ordine[4]]);
		}
		return contatto;
		}
		else
		{
			System.out.println("Error! Intepret must be prepared");
			return null;
		}
	}
	private String[] prepareString(String s,boolean b)
	{
		String reg;
		if(b)
		{
		s=s.substring(1,s.length()-1);
		 reg = "\";\"";
		}
		else
		{
			 reg = ";";
		}
		String[] intest=s.split(reg);
		if(intest.length!=5)
		{
			String[] newArray= new String[5];
			int c=0;
			for(String i : intest)
			{
				newArray[c]=i;
				c++;
			}
			newArray[c] = "";
			intest = newArray;
		}
		return intest;
	}

}
