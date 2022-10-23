package P04InterfacesAndAbstractionExercises.P04FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");

            Buyer buyer;
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            if (data.length == 4) {
                String citizenId = data[2];
                String citizenBirthDate = data[3];

                buyer = new Citizen(name, age, citizenId, citizenBirthDate);
            } else {
                String group = data[2];

                buyer = new Rebel(name, age, group);
            }
            buyers.put(name, buyer);
        }

        String buyerName = scanner.nextLine();

        while (!"End".equals(buyerName)) {
            if (buyers.containsKey(buyerName)) {
                buyers.get(buyerName).buyFood();
            }
            buyerName = scanner.nextLine();
        }

        System.out.println(buyers.values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum());
    }
}
