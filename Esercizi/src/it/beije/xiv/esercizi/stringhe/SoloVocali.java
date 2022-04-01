package it.beije.xiv.esercizi.stringhe;

public class SoloVocali {
    public static void main(String[] args) {
       String string= "Hello Worload ";
        m1(string);
        System.out.println("\n");
        m2(string);
    }

    // senza break poiche non esegue altre istruzioni si potrebbero
    // togliere i break anche se si potrebbero riscontrare errori
    // in fase di manutenzione
    private static void m1(String string) {
        for (int i =0;i<string.length();i++) {
            char pos=string.charAt(i);
            switch (pos){
                case 'A':
                case 'a':
                case 'E':
                case 'e':
                case 'I':
                case 'i':
                case 'O':
                case 'o':
                case 'U':
                case 'u': {
                    System.out.print(pos+" ");
                    break;
                }
            }
        }
    }

    //con break
    private static void m2(String string) {
        for (int i =0;i<string.length();i++) {
            char pos=string.charAt(i);
            switch (pos){
                case 'A':{
                    System.out.print(pos);
                    break;
                }
                case 'a':{
                    System.out.print(pos);
                    break;
                }
                case 'e':{
                    System.out.print(pos);
                    break;
                }
                case 'E':{
                    System.out.print(pos);
                    break;
                }
                case 'I':{
                    System.out.print(pos);
                    break;
                }
                case 'i':{
                    System.out.print(pos);
                    break;
                }
                case 'o':{
                    System.out.print(pos);
                    break;
                }
                case 'O':{
                    System.out.print(pos);
                    break;
                }
                case 'U':{
                    System.out.print(pos);
                    break;
                }
                case 'u':{
                    System.out.print(pos);
                    break;
                }
            }
        }
    }


}
