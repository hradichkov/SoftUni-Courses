package P05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> comparator = (num1, num2) -> {
            if (num1 % 2 == 0 && num2 % 2 != 0) {
                return -1;
            } else if (num1 % 2 != 0 && num2 % 2 == 0) {
                return 1;
            } else {
                return num1.compareTo(num2);
            }
        };

        Arrays.sort(numList, comparator);
        Arrays.stream(numList).forEach(e -> System.out.print(e + " "));
    }
}
