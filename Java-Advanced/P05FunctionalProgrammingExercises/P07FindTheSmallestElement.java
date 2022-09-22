package P05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> minElementIndex = list -> {
//            int minValue = Integer.MAX_VALUE;
//            int index = -1;
//
//            for (int i = 0; i < numList.size(); i++) {
//                if (numList.get(i) <= minValue) {
//                    minValue = numList.get(i);
//                    index = i;
//                }
//            }
//            return index;

            int minNum = list.stream().mapToInt(e -> e).min().getAsInt();
            return list.lastIndexOf(minNum);
        };
        System.out.println(minElementIndex.apply(numList));
    }
}
