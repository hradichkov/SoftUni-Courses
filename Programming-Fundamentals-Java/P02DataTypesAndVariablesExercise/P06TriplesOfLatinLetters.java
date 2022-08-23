package P02DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P06TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int end = 97 + n;

        for (int i = 97; i < end; i++) {
            for (int j = 97; j < end; j++) {
                for (int k = 97; k < end; k++) {
                    System.out.printf("%c%c%c%n", i, j, k);
                }
            }
        }
    }
}
