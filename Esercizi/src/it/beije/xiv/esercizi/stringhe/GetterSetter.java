package it.beije.xiv.esercizi.stringhe;


public class GetterSetter {
    public static void main(String[] args) {
        String name="totale d_i ca$h";

        System.out.println("Stringa originale: "+name);

        String msg=setSetter(name);
        if(msg==null){
            System.err.println("setSetter(name): Ci Sono Caratteri non ammessi");
        }else{
            System.out.println("================= Setter =================\n");
            System.out.println(msg);
        }

        String msg2=setGetter(name);
        if(msg2==null){
            System.err.println("setGetter(name): Ci Sono Caratteri non ammessi ");
        }else{
            System.out.println("\n================= Getter =================\n");
            System.out.println(msg2);
        }
    }


    public static String setSetter(String name){
        String s= "public void set<p>(String <pl>) { \n\tthis.<pl> = <pl>;\n}";
        StringBuilder newName=removeSpaceAndCammelCase(name);
        if(newName==null){
            return null;
        }else{
            return s.replace("<p>",firstUp(newName)).replace("<pl>", firstLo(newName));
        }
    }

    private static StringBuilder removeSpaceAndCammelCase(String name) {
        StringBuilder s= new StringBuilder();

        boolean space=false;
        for(int i=0; i<name.length(); i++){

           char c=name.charAt(i);

           if(i==0 && isDigit(c)){
               return null;
           }
           if(!isLetter(c) && !isDigit(c)){
               if(c!=' ' && c!='_' && c!='$'){
                   return null;
               }
           }
           if(c==' '){
               space = true;
           } else{
               if(space){
                   space = false;
                   c = Character.toUpperCase(name.charAt(i));
               }
               s.append(c);
           }

       }
        return s;
    }

    public static String setGetter(String name){
        String s= "public String get<p>() { \n\treturn <pl>;\n}";
        StringBuilder newName=removeSpaceAndCammelCase(name);
        if(newName==null){
            return null;
        }else{
            return s.replace("<p>",firstUp(newName)).replace("<pl>", firstLo(newName));
        }

    }
    private static boolean isDigit(char c){
        return '0' <= c && c <= '9' ;
    }

    private static boolean isLetter(char c){
        return 'a' <= c && c <= 'z' ||'A' <= c && c <= 'Z' ;
    }

    private static String firstUp(StringBuilder text){
        StringBuilder firstUp= new StringBuilder();
        firstUp.append(text.substring(0, 1).toUpperCase());
        firstUp.append(text.substring(1));
        return firstUp.toString();
    }

    private static String firstLo(StringBuilder text){
        StringBuilder firstUp= new StringBuilder();
        firstUp.append(text.substring(0, 1).toLowerCase());
        firstUp.append(text.substring(1));
        return firstUp.toString();
    }


}
