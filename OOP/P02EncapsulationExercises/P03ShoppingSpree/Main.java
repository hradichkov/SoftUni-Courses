package P02EncapsulationExercises.P03ShoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personInput = scanner.nextLine().split(";");
        String[] productInput = scanner.nextLine().split(";");

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        for (String personData : personInput) {
            String[] personParts = personData.split("=");
            String name = personParts[0];
            double money = Double.parseDouble(personParts[1]);

            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        for (String productData : productInput) {
            String[] productParts = productData.split("=");
            String name = productParts[0];
            double cost = Double.parseDouble(productParts[1]);

            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] data = input.split(" ");
            String personName = data[0];
            String productName = data[1];

            Person buyer = people.get(personName);
            Product productToBuy = products.get(productName);
            try {
                buyer.buyProduct(productToBuy);
                // people.get(personName).buyProduct(products.get(productName));

                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
        people.values().forEach(System.out::println);
    }
}
