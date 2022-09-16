package P03SetsAndMapsExercises;

import java.util.HashMap;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        HashMap<String, String> map = new HashMap<>();

        while (!input.equals("search")) {
            String[] data = input.split("-");
            String name = data[0];
            String number = data[1];

            map.put(name, number);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {
            if (map.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, map.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = scanner.nextLine();
        }
    }
}
