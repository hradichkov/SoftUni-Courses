package P08TextProcessingExercise;

import java.util.Scanner;

public class P04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder encryptedInput = new StringBuilder();

        for (char symbol : input.toCharArray()) {
            char encryptedSymbol = (char) (symbol + 3);
            encryptedInput.append(encryptedSymbol);
        }
        System.out.println(encryptedInput);
    }
}
