package P01WorkingWithAbstractionExercises.P02CardRank;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println("Card Ranks:");
        Arrays.stream(CardRanks.values())
                .forEach(card -> System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card.name()));

//        for (CardRanks cardRank : CardRanks.values()) {
//            System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.ordinal(), cardRank.name());
//        }
    }
}
