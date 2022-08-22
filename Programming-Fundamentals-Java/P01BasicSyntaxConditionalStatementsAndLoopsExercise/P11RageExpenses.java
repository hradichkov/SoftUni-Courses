package P01BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P11RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int games = Integer.parseInt(scanner.nextLine());
        double headset = Double.parseDouble(scanner.nextLine());
        double mouse = Double.parseDouble(scanner.nextLine());
        double keyboard = Double.parseDouble(scanner.nextLine());
        double display = Double.parseDouble(scanner.nextLine());

        double totalCost = 0;

        int count = 0;

        for (int i = 0; i < games; i++) {
            count++;

            if (count % 2 == 0) {
                totalCost += headset;
            }
            if (count % 3 == 0) {
                totalCost += mouse;
            }
            if (count % 6 == 0) {
                totalCost += keyboard;
            }
            if (count % 12 == 0) {
                totalCost += display;
            }

        }
        System.out.printf("Rage expenses: %.2f lv.", totalCost);
    }
}

