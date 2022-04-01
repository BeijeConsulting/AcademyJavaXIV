package it.beije.xiv.esercizi.discord1;


import com.sun.istack.internal.NotNull;

public class StringUtil {
    //TODO
    private static void p(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {
        p("substring(\"Ciao\",0) = "+substring("Ciao4",0));
        p("substring(\"Ciao\",3,1) = "+substring("012345678",0,9));
        p("toLowerCase(\"CIAO34-2\") = "+toLowerCase("CIAO34-2"));
        p("toUpperCase(\"ciao20-\") = "+toUpperCase("ciao20-"));
        p("equals(\"ciao\",\"iao\") = "+equals("ciao","iao"));
        p("equals(\"ciao\",\"ciao\") = "+equals("ciao","ciao"));
        p("equalsIgnoreCase(\"ciao\",\"CIA\") = "+equalsIgnoreCase("ciao","CIA"));
        p("equalsIgnoreCase(\"ciao\",\"CIAO\") = "+equalsIgnoreCase("ciao","CIAO"));
        p("contains(\"ciao\",\"ao\") = "+contains("ciao","ao"));
         p("contains(\"ciao\",\"ciao\") = "+contains("ciao","ciao"));
        p("contains(\"ciao\",\"\") = "+contains("ciao",""));
        p("contains(\"ciao\",\"\") = "+contains("ciao",""));
        p("startsWith(\"ciao\",\"ci\") = "+startsWith("ciao","ci"));
        p("startsWith(\"ciao\",\"ciaoo\") = "+startsWith("ciao","ciaoo"));
        p("startsWith(\"ciao\",\"ciaoo\") = "+startsWith("ciao",""));
        p("endsWith(\"ciao\",\"ao\") = "+endsWith("ciao","ao"));
        p("endsWith(\"ciaomiacara\",\"ar\") = "+endsWith("ciaomiacara","ar"));
        p("endsWith(\"ciaomiacara\",\"\") = "+endsWith("ciaomiacara",""));
        //p("contains(\"ciao\",\"lo\") = "+contains("ciao","lo"));
        //p("replace(\"TESTO\",\"O\",\"A\") = "+replace("TESTO",'O','A'));

        // p("replace(\"Con le mani con le  mani, ciao ciao\",\"mani\",\"culo\") = "+replace("Con le mani con le  mani, ciao ciao","mani","culo"));
        // p("trim(\"    hello word!  \") = "+trim("    hello word!  "));
        // p("trim(\"hello word!\") = "+trim("hello word!"));

        //p(" = ");
    }

    public static String substring(String s, int beginIndex){
        String ns="";
        if((s.length())>=beginIndex){
            for (int i =beginIndex;i<s.length();i++){
                ns+=s.charAt(i);
            }
        }
        return ns;
    }
    public static String substring(String s, int beginIndex, int endIndex){
        String ns="";
        if((s.length())>=beginIndex && endIndex<=(s.length())){
            for (int i =beginIndex;i<endIndex;i++){
                ns+=s.charAt(i);
            }
        }
        return ns;
    }
    public static String toLowerCase(String s){
        String ns="";
        for (char c:s.toCharArray()) {
            if(('A' <=c && c <= 'Z')){
                ns+=((char)(c+32));
            }else{
                ns+=c;
            }
        }
        return ns ;
    }
    public static String toUpperCase(String s){
        String ns="";
        for (char c:s.toCharArray()) {
            if(('a'<= c && c <='z')){
                ns += ((char)(c-32));
            }else{
                ns+=c;
            }
        }
        return ns ;
    }
    public static boolean equals(String s1, String s2){
        if(s1.length()==s2.length()){
            for (int i = 0; i < s1.length(); i++) {
                if(s1.charAt(i) != s2.charAt(i)){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
    public static boolean equalsIgnoreCase(String s1, String s2){
        if(s1.length()==s2.length()){
            for (int i = 0; i < s1.length(); i++) {
                if(toLowerCase(s1).charAt(i) != toLowerCase(s2).charAt(i)){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
    public static boolean contains( String s, String str){
        if(s.length() >= str.length()){
            for (int i = 0; i <=(s.length()-str.length()) ; i++) {

                String tmp=substring(s ,i,i+(str.length()));
                if(equals(tmp,str)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean startsWith(String s, String prefix){
        if(s.length()<prefix.length()||equals(prefix,"")){
            return false;
        } else{
            return s.substring(0,prefix.length()).equals(prefix);
        }
    }
    public static boolean endsWith(String s, String suffix){
        if(s.length()<suffix.length()||equals(suffix,"")){
            return false;
        } else{
            return s.substring(s.length()-suffix.length(),s.length()).equals(suffix);
        }
    }

    public static String replace(String s, char oldChar, char newChar){
        if (oldChar != newChar) {
            int lengthString = s.length();
            char[] arrayValue = s.toCharArray();
            int index = -1;

            while (++index < lengthString) {
                if (arrayValue[index] == oldChar) {
                    break;
                    }
            }
            if (index < lengthString) {
                char ns[] = new char[lengthString];
                for (int j=0; j < index; j++) {
                      ns[j]= arrayValue[j];
                }
                while (index < lengthString) {
                    char c= arrayValue[index];
                    ns[index]= (c == oldChar) ? newChar : c;
                    index++;
                }
                return new String(ns);
            }
        }
        s.replace("","");
        return s;
    }

    public static String replace(String s, String oldChar, String newChar){
        //TODO
        return "";
    }
    public static String trim(String s){
        int indexLast = s.length();
        int indexFirst = 0;
        char[] arraystring = s.toCharArray();

        while ((indexFirst < indexLast) && (arraystring[indexFirst] <= ' ')) {
            indexFirst++;}
        while ((indexFirst < indexLast) && (arraystring[indexLast - 1] <= ' ')) {
            indexLast--;}

        return ((indexLast < s.length()||(indexFirst > 0))) ? substring(s,indexFirst, indexLast):s;
    }



}
