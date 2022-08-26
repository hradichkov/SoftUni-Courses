package P04Methods;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        totalPrice(product, quantity);

    }

    static void totalPrice(String product, int quantity) {
        double totalPrice = 0;
        switch (product) {
            case "coffee":
                totalPrice = 1.5 * quantity;
                break;
            case "water":
                totalPrice = 1.0 * quantity;
                break;
            case "coke":
                totalPrice = 1.4 * quantity;
                break;
            case "snacks":
                totalPrice = 2 * quantity;
                break;
        }
        System.out.printf("%.2f", totalPrice);
    }
}
