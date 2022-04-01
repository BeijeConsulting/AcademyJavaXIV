package it.beije.xiv.esercizi.discord1;


public class StringBuilderUtil {


    public static void main(String[] args) {
        System.out.println(substring(new StringBuilder("CiaoCiao"),1));
        System.out.println(substring(new StringBuilder("CiaoCiao"),1,3));
        System.out.println(reverse(new StringBuilder("CiaoCiao")));
        System.out.println(delete(new StringBuilder("Ciao45Ciao"),4,"Ciao45Ciao".length()));
    }

    public static String substring(StringBuilder sb, int beginIndex){

        StringBuilder nsb=new StringBuilder();
        if((sb.length())>=beginIndex){
            for (int i =beginIndex;i<sb.length();i++){
                nsb.append(sb.charAt(i));
            }
        }
        return nsb.toString();

    }
    public static String substring(StringBuilder sb, int beginIndex, int endIndex){
        StringBuilder nsb=new StringBuilder();
        if((sb.length())>=beginIndex && endIndex<=(sb.length())){
            for (int i =beginIndex;i<endIndex;i++){
                nsb.append(sb.charAt(i));
            }
        }
        return nsb.toString();
    }
    public static StringBuilder delete(StringBuilder sb, int start, int end){
        StringBuilder nsb= new StringBuilder();
        nsb.append(substring(sb,0 ,start));
        nsb.append(substring(sb,end,sb.length()));
        return nsb;
    }
    public static StringBuilder reverse(StringBuilder sb){
        StringBuilder nsb=new StringBuilder();

        for(int i=sb.length()-1;i >= 0;i--){
            nsb.append(sb.charAt(i));
        }
        return nsb;
    }



}
