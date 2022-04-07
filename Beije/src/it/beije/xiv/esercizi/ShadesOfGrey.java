package it.beije.xiv.esercizi;

/*	 Scrivere una funzione che prende un numero intero n come parametro e ritorna un array di sfumature di grigio
 *   in codice esadecimale (#aaaaaa, per esempio). L’array dovrebbe essere ordinato
 *   in senso ascendente (#010101, #020202, ecc), usando le lettere minuscole.
 *   public class ShadesOfGrey {static String[] shadesOfGrey(int num) {// returns n shades of grey in an array}}
 *   Ricorda che: il grigio è un colore composto dalla stessa quantità 
 *   di rosso, verde e blu: #010101, #aeaeae, #555555. Inoltre: #000000 e #FFFFFF non sono valori accettati.
 *   Se n è negativo ritornare un array vuoto, se n è maggiore di 254, ritornare un array di 254 elementi.
 */


public class ShadesOfGrey
{
	public static String convertedNumber = "";
	
	public static void main(String[] args)
	{
		int n = 254;
		ShadesOfGrey sg = new ShadesOfGrey();
		
		String[] shades = sg.shadesOfGrey(n);
		
		for(String s : shades)
		{
			System.out.print(s);
		}
	}
	
	public String[] shadesOfGrey(int num)
	{
		String[] s = {};
		if (num < 0) return s;
		else if (num > 254) num = 254;
		
		s = new String[num];
		
		for(int i = 0; i < num; i++)
		{
			s[i] = generateNewShade(i);
		}
		
		return s;
	}
	
	private String generateNewShade(int n)
	{
		if (n == 0) return "";
		
		decToHex(n);
		
		String color = convertedNumber;
		convertedNumber = "";

		if (color.length() == 1) color = "0" + color;
		color = "#" + color + color + color + "\n";
		
		return color;
	}
	
	private int decToHex(int n)
	{
		int resto = n % 16;
		
        if (resto < 10) convertedNumber = resto + convertedNumber;
        else
        {
            switch (resto)
            {
                case 10:
                    convertedNumber = "a" + convertedNumber;
                    break;

                case 11:
                    convertedNumber = "b" + convertedNumber;
                    break;

                case 12:
                    convertedNumber = "c" + convertedNumber;
                    break;

                case 13:
                    convertedNumber = "d" + convertedNumber;
                    break;

                case 14:
                    convertedNumber = "e" + convertedNumber;
                    break;

                case 15:
                    convertedNumber = "f" + convertedNumber;
                    break;
            }
        }

        if (n < 16) return 0;

        return decToHex(n / 16);
	}
}
