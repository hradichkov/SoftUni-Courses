package P03SetsAndMapsExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            usernames.add(input);
        }

//        for (String username : usernames) {
//            System.out.println(username);
//        }
        usernames.forEach(System.out::println);
        // usernames.forEach(username -> System.out.println(username));
    }
}
