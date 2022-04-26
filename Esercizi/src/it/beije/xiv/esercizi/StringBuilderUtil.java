package it.beije.xiv.esercizi;

public class StringBuilderUtil {

    public static StringBuilder substring(StringBuilder sb, int beginIndex) {
        StringBuilder sb1 = new StringBuilder();

        for (int i = beginIndex; i < sb.length(); i++) {
            sb1.append(sb.charAt(i));
        }

        return sb1;
    }

    public static StringBuilder substring(StringBuilder sb, int beginIndex, int endIndex) {
        StringBuilder sb1 = new StringBuilder();

        for (int i = beginIndex; i < endIndex; i++) {
            sb1.append(sb.charAt(i));
        }

        return sb1;
    }

    public static StringBuilder delete(StringBuilder sb, int start, int end) {
        StringBuilder sb1 = new StringBuilder();

        for(int i = 0; i < start; i++) {
            sb1.append(sb.charAt(i));
        }

        for(int i = end; i < sb.length(); i++) {
            sb1.append(sb.charAt(i));
        }

        return sb = sb1;
    }

    public static StringBuilder reverse(StringBuilder sb) {
        StringBuilder sb1 = new StringBuilder();

        for(int i = sb.length() - 1; i >= 0; i--) {
            sb1.append(sb.charAt(i));
        }

        return sb = sb1;
    }
}
