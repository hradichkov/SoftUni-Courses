package P05ListsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<String> guestList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> input = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
            String name = input.get(0);

            if (input.size() == 3) {
                if (guestList.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guestList.add(name);
                }
            } else {
                if (guestList.contains(name)) {
                    guestList.remove(name);
                } else {
                    System.out.printf("%s is not in the list!%n", name);
                }
            }
        }
        for (String name : guestList) {
            System.out.println(name);
        }
    }
}
