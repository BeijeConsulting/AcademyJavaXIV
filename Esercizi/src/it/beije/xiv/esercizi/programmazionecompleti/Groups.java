package it.beije.xiv.esercizi.programmazionecompleti;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Giuseppe Raddato
 * Data: 02 apr 2022
 */
public class Groups {
    public static void main(String[] args) {
        String trueS="({})" +
                        "[[]()]" +
                        "[{()}]" +
                        "({d})" +
                        "[[s]d()]";
        String falseS ="{(})\n" +
                "([]\n" +
                "[])";


        System.out.println(groupCheck(trueS));
        System.out.println(groupCheck(falseS));



    }
    public static boolean groupCheck(String s) {
        ArrayList<Character> stack = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c=='('  || c=='{' || c=='[')
            {
                stack.add(c);
                continue;
            }

            //nel caso il carattare fosse una parentesi aperta già dal primo avvio
            if (stack.isEmpty()){
                return false;
            }

            char lastChar;
            switch (c) {
                case ')':
                    lastChar = stack.get(stack.size()-1);
                    stack.remove(stack.size()-1);
                    if (lastChar=='{' || lastChar=='['){ return false; }
                    break;

                case '}':
                    lastChar = stack.get(stack.size()-1);
                    stack.remove(stack.size()-1);
                    if (lastChar=='(' || lastChar=='['){ return false; }
                    break;

                case ']':
                    lastChar = stack.get(stack.size()-1);
                    stack.remove(stack.size()-1);
                    if (lastChar=='{' || lastChar=='(' ){ return false; }
                    break;
            }
        }

        return true;
    }
}
