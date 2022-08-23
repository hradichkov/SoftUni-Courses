package P02DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String symbol = scanner.nextLine();
            char numSymbol = symbol.charAt(0);

            System.out.printf("%c", numSymbol + key);
        }
    }
}
