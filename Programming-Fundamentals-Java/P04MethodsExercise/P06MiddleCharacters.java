package P04MethodsExercise;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddleChar(input);
    }

    private static void printMiddleChar(String input) {
        if (input.length() % 2 != 0) {
            char symbol = input.charAt(input.length() / 2);
            System.out.println(symbol);
        } else {
            char symbol = input.charAt(input.length() / 2 - 1);
            char symbol2 = input.charAt(input.length() / 2);
            System.out.print(symbol + "" + symbol2);
        }
    }
}
