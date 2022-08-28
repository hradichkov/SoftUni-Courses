package P04MethodsExercise;

import java.util.Locale;
import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        printVowelsCount(word);

    }

    private static void printVowelsCount(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char symbol = word.toLowerCase().charAt(i);

            if (symbol == 97 || symbol == 101 || symbol == 105 || symbol == 111 || symbol == 117 || symbol == 121) {
                count++;
            }
        }
        System.out.println(count);
    }
}
