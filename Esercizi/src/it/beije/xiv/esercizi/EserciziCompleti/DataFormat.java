package it.beije.xiv.esercizi.EserciziCompleti;
import java.util.Scanner;
import java.time.*;

public class DataFormat {
	
	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserire Data: ");
		String s = input.nextLine().replace("/", "");
		String s1 = s.substring(0,2);
		String s2 = s.substring(2,4);
		String s3 = s.substring(4);
		int day = Integer.parseInt(s1);
		int month = Integer.parseInt(s2);
		int year = Integer.parseInt(s3);
		LocalDate date = LocalDate.of(year, month, day);
		LocalDate start = LocalDate.of(year, 1, 1);
		Period period1 = Period.ofDays(1);
		
		int contaGiorni = 1;
		int contaSettimane = 1;
		
		for(int i=1; start.isBefore(date);i++) {
			start = start.plus(period1);
			contaGiorni++;
			if(i%7==0) contaSettimane++;
		}
		System.out.print(date.getDayOfWeek()+" "+ day+ " "+ date.getMonth()+", GIORNO "+contaGiorni+" DELL'ANNO "
		+year+", SETTIMANA NUMERO "+contaSettimane);
		
		
		
	}
}
