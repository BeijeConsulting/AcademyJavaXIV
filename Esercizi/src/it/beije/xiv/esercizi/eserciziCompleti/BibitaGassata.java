package it.beije.xiv.esercizi.eserciziCompleti;
import java.time.*;
public class BibitaGassata {
	final static int content=4000;
	final static int evapPerDay=2;
	final static int threshold=25;
public static void main(String...args)
{
	LocalDate date = LocalDate.now();
	date=date.plusDays(daysTillExpiry());
	System.out.println("Last day to bottle: "+date.getDayOfMonth()+" "+date.getMonth());
}
static int daysTillExpiry()
{
	int daysTillExpiry=(evapPerDay%2==0)?((100-threshold)/evapPerDay):((100-threshold)/evapPerDay + 1);
	
	return daysTillExpiry;
}
}
