package P07AssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> parking = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String command = data[0];
            String username = data[1];

            switch (command) {
                case "register":
                    String licensePlate = data[2];

                    if (parking.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlate);
                    } else {
                        parking.put(username, licensePlate);
                        System.out.printf("%s registered %s successfully%n", username, licensePlate);
                    }
                    break;

                case "unregister":
                    if (!parking.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found%n", username);
                    } else {
                        parking.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }
                    break;
            }
        }
        for (Map.Entry<String, String> entry : parking.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
