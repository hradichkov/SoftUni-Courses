package P05Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> data = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = data.get(0);

            switch (command) {
                case "Contains":
                    int containsNum = Integer.parseInt(data.get(1));
                    boolean isContained = false;

                    for (int i = 0; i < numList.size(); i++) {
                        if (numList.get(i) == containsNum) {
                            System.out.println("Yes");
                            isContained = true;
                            break;
                        }
                    }
                    if (!isContained) {
                        System.out.println("No such number");
                    }
                    break;

                case "Print":
                    String evenOrOdd = data.get(1);

                    if (evenOrOdd.equals("even")) {
                        for (int i = 0; i < numList.size(); i++) {
                            if (numList.get(i) % 2 == 0) {
                                System.out.print(numList.get(i) + " ");
                            }
                        }
                    } else {
                        for (int i = 0; i < numList.size(); i++) {
                            if (numList.get(i) % 2 != 0) {
                                System.out.print(numList.get(i) + " ");
                            }
                        }
                    }
                    System.out.println();
                    break;

                case "Get":
                    int sum = 0;

                    for (int i = 0; i < numList.size(); i++) {
                        sum += numList.get(i);
                    }
                    System.out.println(sum);
                    break;

                case "Filter":
                    String condition = data.get(1);
                    int number = Integer.parseInt(data.get(2));

                    switch (condition) {
                        case "<":
                            for (int i = 0; i < numList.size(); i++) {
                                if (numList.get(i) < number) {
                                    System.out.print(numList.get(i) + " ");
                                }
                            }
                            break;
                        case ">":
                            for (int i = 0; i < numList.size(); i++) {
                                if (numList.get(i) > number) {
                                    System.out.print(numList.get(i) + " ");
                                }
                            }
                            break;
                        case ">=":
                            for (int i = 0; i < numList.size(); i++) {
                                if (numList.get(i) >= number) {
                                    System.out.print(numList.get(i) + " ");
                                }
                            }
                            break;
                        default:
                            for (int i = 0; i < numList.size(); i++) {
                                if (numList.get(i) <= number) {
                                    System.out.print(numList.get(i) + " ");
                                }
                            }
                            break;
                    }
                    System.out.println();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
