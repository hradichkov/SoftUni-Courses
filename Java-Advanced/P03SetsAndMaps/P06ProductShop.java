package P03SetsAndMaps;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Map<String, List<Double>>> hashMap = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] data = input.split(", ");
            String store = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            hashMap.putIfAbsent(store, new LinkedHashMap<>());
            hashMap.get(store).put(product, new ArrayList<>());
            hashMap.get(store).get(product).add(price);

            input = scanner.nextLine();
        }

        hashMap.entrySet().forEach(e -> {
            System.out.println(e.getKey() + "->");
            Map<String, List<Double>> productsAndPrices = e.getValue();

            productsAndPrices.entrySet().forEach(product -> {
                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue().get(0));
            });
        });
    }
}
