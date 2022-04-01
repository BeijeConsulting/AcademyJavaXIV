package it.beije.xiv.esercizi.stringhe;

public class ContaC {
    public static void main(String[] args) {

        String input= "Ciccio";
        char search = 'c';

        ContaC contaC= new ContaC();

        System.out.println(contaC.contaLettera(search,input));

    }


    public int contaLettera(char c, String str){
        int count=0;
        for(int i = 0; i< str.length();i++){
            if(str.charAt(i)==c){
                count++;
            }
        }
        return count;
    }
}
