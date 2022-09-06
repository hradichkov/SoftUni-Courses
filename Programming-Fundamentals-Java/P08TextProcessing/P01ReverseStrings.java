package P08TextProcessing;

import java.util.Scanner;

public class P01ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String reversedInput = "";
            for (int i = input.length() - 1; i >= 0; i--) {
                reversedInput += input.charAt(i);
            }

            System.out.printf("%s = %s%n", input, reversedInput);

            input = scanner.nextLine();
        }
    }
}
