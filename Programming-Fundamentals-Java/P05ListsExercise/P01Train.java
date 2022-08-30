package P05ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> data = Arrays.stream(input.split(" ")).collect(Collectors.toList());

            if (data.size() == 2) {
                int addWagon = Integer.parseInt(data.get(1));
                wagons.add(addWagon);

            } else {
                int passengers = Integer.parseInt(data.get(0));

                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + passengers <= maxCapacity) {
                        wagons.set(i, wagons.get(i) + passengers);
                        break;
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}
