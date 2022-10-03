package P08IteratorsAndComparatorsExercises.P02Lake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String endInput = scanner.nextLine();


        Lake lake = new Lake(numbersList);
        List<String> result = new ArrayList<>();

        for (Integer num : lake) {
            result.add(num + "");
        }

        System.out.println(String.join(", ", result));
    }
}
