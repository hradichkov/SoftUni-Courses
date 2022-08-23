package P02DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int totalSpice = 0;
        int currentYield = yield;

        while (currentYield >= 100) {
            days++;
            totalSpice += currentYield - 26;
            currentYield -= 10;
        }

        if (yield > 99) {
            totalSpice -= 26;
        }

        System.out.printf("%d%n", days);
        System.out.printf("%d%n", totalSpice);
    }
}
