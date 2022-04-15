package it.beije.turing.xmlparser6;

public class Token
{															//CREO STRINGHE SOLO PER RICORDARMELE, ANDREBBERO CREATI TOKEN A RUNTIME
	public String openToken = "<\\w+( \\w+=\".*\")*>";		//APERTURA TAG CON S^POSSIBILI ATTRIBUTI
	public String closeToken = "</\\w+>";					//CHIUSURA TAG
	
	
	//			<NOME a="CIAO" b="">   <NOME>  </ABC>
}