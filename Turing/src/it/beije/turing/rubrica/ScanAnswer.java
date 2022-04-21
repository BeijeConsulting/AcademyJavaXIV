package it.beije.turing.rubrica;

import java.util.Scanner;

public class ScanAnswer {

    public static String isValidAnswer(Scanner scanner, int min, int max) {
        boolean repeat = false;
        String answer = null;

        do {
            if (scanner.hasNext()) answer = scanner.next();

            try {
                while ((answer == null) || (Integer.parseInt(answer) < min || Integer.parseInt(answer) > max)) {
                    System.err.println("Input valid number");
                    answer = scanner.next();
                }
                repeat = false;
            } catch (NumberFormatException nfEx) {
                System.err.println("You can input only numbers");
                repeat = true;
            }
        } while (repeat);

        return answer;
    }
}
