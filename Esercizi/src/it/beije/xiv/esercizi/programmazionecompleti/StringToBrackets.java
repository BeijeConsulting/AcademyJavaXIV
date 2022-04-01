package it.beije.xiv.esercizi.programmazionecompleti;

/**
 * @author Giuseppe Raddato
 * Data: 02 apr 2022
 */
public class StringToBrackets {
    public static void main(String[] args) {
            System.out.println(convert("(( @"));

    }

   public static String convert(String param){


       StringBuilder sb= new StringBuilder(param.toLowerCase());
       StringBuilder newS= new StringBuilder();

       for (int i=0;i<=sb.length();i++){

           sb=new StringBuilder(param.toLowerCase());

           Character c=sb.charAt(i);
           sb.deleteCharAt(i);

            System.out.println(sb+" " + c+ " "+ sb.toString().contains(c.toString() ));

           if(sb.toString().contains(c.toString()) ){
               newS.append(")");
           }else {
               newS.append("(");
           }
       }

        return newS.toString();
   }
}
