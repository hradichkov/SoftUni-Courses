package P08TextProcessingExercise;

import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] passwords = scanner.nextLine().split("\\s+");

        double sum = 0;

        for (String password : passwords) {
            char firstLetter = password.charAt(0);
            char secondLetter = password.charAt(password.length() - 1);

            double number = Double.parseDouble(password.replace(firstLetter, ' ').replace(secondLetter, ' ').trim());

            //StringBuilder sb = new StringBuilder(password);
            //double number = Double.parseDouble(sb.deleteCharAt(0).deleteCharAt(sb.length() - 1).toString());

            if (Character.isUpperCase(firstLetter)) {
                number /= firstLetter - 64;
            } else {
                number *= firstLetter - 96;
            }

            if (Character.isUpperCase(secondLetter)) {
                number -= secondLetter - 64;
            } else {
                number += secondLetter - 96;
            }

            sum += number;
        }
        System.out.printf("%.2f", sum);
    }
}
