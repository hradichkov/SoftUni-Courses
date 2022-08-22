package P01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        int price = 0;

        if (day.equals("Weekday")) {
            if (age <= 0 && age <= 18) {
                price = 12;
            } else if (age <= 64) {
                price = 18;
            } else if (age <= 122) {
                price = 12;
            }
        } else if (day.equals("Weekend")) {
            if (age >= 0 && age <= 18) {
                price = 15;
            } else if (age <= 64) {
                price = 20;
            } else if (age <= 122) {
                price = 15;
            }
        } else {
            if (age >= 0 && age <= 18) {
                price = 5;
            } else if (age <= 64) {
                price = 12;
            } else if (age <= 122) {
                price = 10;
            }
        }
        if (age >= 0 && age <= 122) {
            System.out.printf("%d$", price);
        } else {
            System.out.println("Error!");
        }
    }
}
