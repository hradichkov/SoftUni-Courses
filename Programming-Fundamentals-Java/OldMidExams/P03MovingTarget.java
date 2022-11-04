package OldMidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            List<String> data = Arrays.stream(input.split(" ")).toList();
            int index = Integer.parseInt(data.get(1));
            String command = data.get(0);

            switch (command) {
                case "Shoot" -> {
                    int power = Integer.parseInt(data.get(2));
                    if (index >= 0 && index < targets.size()) {
                        targets.set(index, targets.get(index) - power);

                        if (targets.get(index) <= 0) {
                            targets.remove(index);
                        }
                    }
                }
                case "Add" -> {
                    int value = Integer.parseInt(data.get(2));
                    if (index < 0 || index >= targets.size()) {
                        System.out.println("Invalid placement!");
                    } else {
                        targets.add(index, value);
                    }
                }
                case "Strike" -> {
                    int radius = Integer.parseInt(data.get(2));
                    int num = targets.get(index);
                    if (index - radius < 0 || index + radius >= targets.size()) {
                        System.out.println("Strike missed!");
                    } else {
                        for (int i = 0; i < radius; i++) {
                            targets.remove(index + 1 - i);
                            targets.remove(index - 1 - i);
                        }
                        targets.remove(Integer.valueOf(num));
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < targets.size(); i++) {
            System.out.print(targets.get(i));
            if (i < targets.size() - 1) {
                System.out.print("|");
            }
        }
    }
}
