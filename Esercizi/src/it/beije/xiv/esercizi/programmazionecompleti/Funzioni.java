package it.beije.xiv.esercizi.programmazionecompleti;

/**
 * @author Giuseppe Raddato
 * Data: 01 apr 2022
 */
public class Funzioni {

    //Scrivere la funzione caffeina(int n) che prende un numero positivo come argomento e:
    //Se il numero è divisibile per 3, stampa “Java”
    //Se il numero è divisibile per 3 e per 4, stampa “Coffee”
    //Se il numero appartiene ad uno dei due casi precedenti ed è pari, aggiunge “Script” in fondo alla stringa
    //Se non appartiene a nessuno dei casi precedenti stampa “match_missed!”
    public static void main(String[] args) {

        System.out.println(caffeina(3));
        System.out.println(caffeina(12));
        System.out.println(caffeina(50));
        System.out.println(caffeina(5));
    }
    public static String caffeina(int n){
        StringBuilder b=new StringBuilder();
        if( n % 3==0 && n % 4==0){
            b.append("Coffee");
        }else if(n % 3==0 ){
            b.append("Java");
        } else if (n % 2 == 0) {
            b.append("Script");
        }else {
            b.append("match_missed!");
        }


        return b.toString();
    }
}
