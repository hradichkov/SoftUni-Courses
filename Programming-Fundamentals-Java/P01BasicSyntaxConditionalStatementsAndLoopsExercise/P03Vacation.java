package P01BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;
        double totalPrice = 0;

        if (type.equals("Students")) {
            if (day.equals("Friday")) {
                price = 8.45;
            } else if (day.equals("Saturday")) {
                price = 9.8;
            } else if (day.equals("Sunday")) {
                price = 10.46;
            }
            if (people >= 30) {
                price = price - price * 0.15;
            }
        } else if (type.equals("Business")) {
            if (day.equals("Friday")) {
                price = 10.9;
            } else if (day.equals("Saturday")) {
                price = 15.6;
            } else if (day.equals("Sunday")) {
                price = 16;
            }
            if (people >= 100) {
                totalPrice = -10 * price;
            }
        } else {
            if (day.equals("Friday")) {
                price = 15;
            } else if (day.equals("Saturday")) {
                price = 20;
            } else if (day.equals("Sunday")) {
                price = 22.5;
            }
            if (people >= 10 && people <= 20) {
                price = price - price * 0.05;
            }
        }
        System.out.printf("Total price: %.2f", totalPrice + price * people);

    }
}
