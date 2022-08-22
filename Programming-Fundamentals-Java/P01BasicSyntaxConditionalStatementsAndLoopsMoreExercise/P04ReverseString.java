package P01BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class P04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (int i = input.length(); i > 0; i--) {
            char symbol = input.charAt(i - 1);
            System.out.print(symbol);
        }
    }
}
