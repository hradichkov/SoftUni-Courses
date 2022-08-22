package P01BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double totalSpent = 0;
        boolean isValid = false;

        String game = scanner.nextLine();

        while (!game.equals("Game Time")) {
            double price = 0;
            switch (game) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                default:
                    System.out.println("Not Found");
                    game = scanner.nextLine();
                    continue;
            }
            budget -= price;
            totalSpent += price;

            if (budget > 0) {
                System.out.println("Bought " + game);
            }
            if (budget == 0) {
                System.out.println("Out of money!");
                isValid = true;
                break;
            }
            if (budget < 0) {
                System.out.println("Too Expensive");
                budget += price;
                totalSpent -= price;
            }
            game = scanner.nextLine();
        }
        if (!isValid) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, budget);
        }
    }
}