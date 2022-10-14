package P01WorkingWithAbstractionExercises.P01CardSuit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println("Card Suits:");
        Arrays.stream(Suits.values())
                .forEach(card -> System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card.name()));
    }
}
