package esercizi;


public class StringClass {

	public static void main(java.lang.String[] args) {
		String name = "Fluffy";
		String name2 = "ciao";
		String name3 = "Fluffy"; //string pool
		
		System.out.println("name.contentEquals(name2) -> " + name.contentEquals(name2));
		System.out.println("name == name3 -> " + name == name3);
		System.out.println("name.equals(name3) -> " + name.equals(name3)); //true
		
		
		
		//concatenazione
		System.out.println(name + name2); // concatenazione
		System.out.println(1 + 2); //no concatenazione
		System.out.println("a" + "b"); //concatenazione
		System.out.println("a" + "b" + 1); //ab1
		System.out.println(1 + 2 + "a"); // 3a
		
		int three = 3;
		String four = "4";
		System.out.println(1 + 2 + three + four); //64
		
		
		//length()
		System.out.println("length name " + name.length()); 
		System.out.println("abcde" + "abcde".length());
		
		//charAt()
		System.out.println("name2.charAt (2) " + name2.charAt(2));
		// System.out.println("name2.charAt (4) " + name2.charAt(4)); //java.lang.StringIndexOutOfBoundsException: String index out of range: 4
		
		
		//indexOF()
		System.out.println("indexof 1-> " + name3.indexOf('u'));
		System.out.println("index of 2-> " + name3.indexOf("ff"));
		System.out.println("index of 3-> " + name3.indexOf('a'));
		
		//substring
		String animals = "animals";
		System.out.println("substring -> " + animals.substring(3));
		System.out.println("substring -> " + (animals.substring(animals.indexOf('m'))));
		System.out.println("substring -> " + animals.substring(3, 5));
		
		System.out.println("substring 2 -> " + animals.substring(3, 3));
		
		
		//toLower/UpperCase
		System.out.println("UPPER -> " + animals.toUpperCase());
		System.out.println("lower -> " + "CIAO".toLowerCase() );
		
		//equals equalsignorcase
		System.out.println("equals -> " + animals.equals("ANIMALS"));
		System.out.println("equals ignore case ->" + animals.equalsIgnoreCase(animals.toUpperCase()));
		
		//strart ends with + contains
		System.out.println("starts -> " + "abc".startsWith("a"));
		System.out.println("ends ->"  + animals.endsWith("S"));
		System.out.println("contains -> " + "ABC".contains("b"));
		
		//replace
		System.out.println("replace -> " + animals.replace('a', 'A'));
		
		//trim
		System.out.println("ciao \r come va?");
		System.out.println("trim ->" + "   \n c i a o\n".trim());
		
		//immutabilità
		animals.charAt(2);
		System.out.println("immutabile -> " + animals);
		
		//____________________________
		//STREAMBUILDER
		StringBuilder alpha = new StringBuilder();
		for (char current = 'a' ; current <= 'z' ; current++) {
			alpha.append(current);
		}
		
		System.out.println("stringBuilder -> " + alpha );
		
		//mutability
		StringBuilder sb0 = new StringBuilder("start");
		sb0.append("+middle"); 
		StringBuilder same = sb0.append("+end");
	
		
		String s = "start";
		s += "middle";
		String s1 = s + "end";
		System.out.println("mutability sb -> " + sb0);
		System.out.println("mutability same -> " + same);
		System.out.println("immutability s -> " + s);
		System.out.println("immutability s1 -> " + s1);
		
		//creazione
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder("animals");
		StringBuilder sb3 = new StringBuilder(3);
		
		//append
		sb1.append("ciao");
		sb3.append("sb3");
		
		//insert
		System.out.println("sb2 insert -> " + sb2.insert(0, '-'));
		
		//delete deldeteCharAt
		System.out.println("delete -> " + sb2.delete(1, 3));
		System.out.println("delete char at -> " + sb3.deleteCharAt(1));
		
		//reverse 
		System.out.println("normale -> " + sb2);
		System.out.println("reverse -> " + sb2.reverse());
		
		//tostring
		String toString = sb3.toString();
		
		//uguaglianze
		StringBuilder one = new StringBuilder();
		StringBuilder two = new StringBuilder(); 
		StringBuilder three1 = one.append("a"); 
		System.out.println(one == two); // false 
		System.out.println(one == three1); // true
		
		String x = "Hello World";
		String z = " Hello World".trim(); 
		System.out.println(x.equals(z));
		
		/*esempio discord
		s = "animals";
		String newS = "";
		if (beginIndex > endIndex) throw new Exception();
		for (int i = beginIndex; i < endIndex; i++) {
			newS = newS + s.charAt(i);
		}*/
		
		
		
		
		
		
		
		
	}

}
