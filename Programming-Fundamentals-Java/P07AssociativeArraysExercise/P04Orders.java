package P07AssociativeArraysExercise;

import java.util.*;

public class P04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> productMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String[] data = input.split(" ");
            String product = data[0];
            double price = Double.parseDouble(data[1]);
            int quantity = Integer.parseInt(data[2]);

            if (!productMap.containsKey(product)) {
                productMap.put(product, new ArrayList<>());
                productMap.get(product).add(price);
                productMap.get(product).add(quantity * 1.0);
            } else {
                productMap.get(product).set(0, price);
                productMap.get(product).set(1, productMap.get(product).get(1) + quantity);
            }

            input = scanner.nextLine();
        }

        productMap.forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v.get(0) * v.get(1)));
    }
}
