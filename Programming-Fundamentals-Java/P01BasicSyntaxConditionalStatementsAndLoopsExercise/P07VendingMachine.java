package P01BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String coins = scanner.nextLine();
        double totalMoney = 0;
        double priceNuts = 2;
        double priceWater = 0.7;
        double priceCrisps = 1.5;
        double priceSoda = 0.8;
        double priceCoke = 1;
        boolean isEnough = true;


        while (!coins.equals("Start")) {
            double money = Double.parseDouble(coins);

            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                totalMoney += money;
            } else {
                System.out.printf("Cannot accept %.2f%n", money);
            }

            coins = scanner.nextLine();
        }

        String products = scanner.nextLine();

        while (!products.equals("End")) {

            if (products.equals("Nuts")) {
                if (totalMoney < priceNuts) {
                    isEnough = false;
                    //System.out.println("Sorry, not enough money");
                } else {
                    totalMoney -= priceNuts;
                    System.out.printf("Purchased %s%n", products);
                }

            } else if (products.equals("Water")) {
                if (totalMoney < priceWater) {
                    isEnough = false;
                    //System.out.println("Sorry, not enough money");
                } else {
                    totalMoney -= priceWater;
                    System.out.printf("Purchased %s%n", products);
                }
            } else if (products.equals("Crisps")) {
                if (totalMoney < priceCrisps) {
                    isEnough = false;
                    //System.out.println("Sorry, not enough money");
                } else {
                    totalMoney -= priceCrisps;
                    System.out.printf("Purchased %s%n", products);
                }
            } else if (products.equals("Soda")) {
                if (totalMoney < priceSoda) {
                    isEnough = false;
                    //System.out.println("Sorry, not enough money");
                } else {
                    totalMoney -= priceSoda;
                    System.out.printf("Purchased %s%n", products);
                }
            } else if (products.equals("Coke")) {
                if (totalMoney < priceCoke) {
                    isEnough = false;
                    //System.out.println("Sorry, not enough money");
                } else {
                    totalMoney -= priceCoke;
                    System.out.printf("Purchased %s%n", products);
                }
            } else {
                System.out.println("Invalid product");
            }

            if (!isEnough){
                System.out.println("Sorry, not enough money");
            }

            products = scanner.nextLine();

        }
        System.out.printf("Change: %.2f", totalMoney);
    }
}
