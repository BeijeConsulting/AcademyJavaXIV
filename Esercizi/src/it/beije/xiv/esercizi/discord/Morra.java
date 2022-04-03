package it.beije.xiv.esercizi.discord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Morra {
public static void main(String[] args) {
	
	ArrayList <String> legalmoves = new ArrayList<>(Arrays.asList("carta", "sasso", "forbice"));
	
	Scanner scan = new Scanner(System.in);  					//Move setup
	System.out.println("Player 1 - Enter your move");
	String p1 = scan.nextLine(); 
	System.out.println("Player 2 - Enter your move");
	String p2 = scan.nextLine(); 
	scan.close();
	

	
	while(true) {												
	if (!legalmoves.contains((String)p1)|!legalmoves.contains((String)p2)) {
		System.out.println("illegal input");	//legality check
		break;
		}
	
	if (p1.equals(p2)) {
		System.out.println("The match is a draw");		//draw check
		break;
	} else if (!p1.equals(legalmoves.get(legalmoves.size()-1))&&p2.equals(legalmoves.get(legalmoves.indexOf(p1)+1))) {
		System.out.println("Player 1 wins");		//p1 non ultimo - p2 segue p1
	} else if (!p1.equals(legalmoves.get(0))&&p2.equals(legalmoves.get(legalmoves.indexOf(p1)-1))) {
		System.out.println("Player 2 wins");		//p1 non primo - p2 precede p1
	} else if (p1.equals(legalmoves.get(legalmoves.size()-1))&p2.equals(legalmoves.get(0))) {
		System.out.println("Player 1 wins");		//edge case - p1 ultimo e p2 primo - p2 "segue" p1 
	} else if (p2.equals(legalmoves.get(legalmoves.size()-1))&p1 .equals(legalmoves.get(0))) {
		System.out.println("Player 2 wins");		//edge case - p2 ultimo e p1 primo - p2 "precede" p1
	}
	break; //exit while (match)	
}

System.out.println("The match is over");		//game over notification
}}

