package P08TextProcessingExercise;

import java.util.Scanner;

public class P07StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        int power = 0;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '>') {
                power += input.charAt(i + 1) - 48;
                //power += Integer.parseInt("" + input.charAt(i + 1));
            } else if (power > 0) {
                input.deleteCharAt(i);
                power--;
                i--;
            }
        }
        System.out.println(input);
    }
}
