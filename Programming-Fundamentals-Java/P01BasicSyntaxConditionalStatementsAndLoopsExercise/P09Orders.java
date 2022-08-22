package P01BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        for (int i = 0; i < n; i++) {
            double price = 0;

            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsules = Integer.parseInt(scanner.nextLine());

            price = days * capsules * pricePerCapsule;
            System.out.printf("The price for the coffee is: $%.2f%n", price);
            totalPrice += price;
        }
        System.out.printf("Total: $%.2f", totalPrice);
    }
}
