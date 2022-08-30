package P05ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            List<String> data = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = data.get(0);


            switch (command) {
                case "Add":
                    int addNumber = Integer.parseInt(data.get(1));
                    numList.add(addNumber);
                    break;

                case "Insert":
                    int insertNumber = Integer.parseInt(data.get(1));
                    int insertIndex = Integer.parseInt(data.get(2));

                    if (insertIndex > numList.size() || insertIndex < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numList.add(insertIndex, insertNumber);
                    }
                    break;

                case "Remove":
                    int removeIndex = Integer.parseInt(data.get(1));

                    if (removeIndex > numList.size() || removeIndex < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numList.remove(removeIndex);
                    }
                    break;

                case "Shift":
                    String leftOrRight = data.get(1);
                    int count = Integer.parseInt(data.get(2));

                    if (leftOrRight.equals("left")) {
                        for (int i = 0; i < count; i++) {
                            numList.add(numList.size(), numList.get(0));
                            numList.remove(0);
                        }
                    } else {
                        for (int i = 0; i < count; i++) {
                            numList.add(0, numList.get(numList.size() - 1));
                            numList.remove(numList.size() - 1);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
