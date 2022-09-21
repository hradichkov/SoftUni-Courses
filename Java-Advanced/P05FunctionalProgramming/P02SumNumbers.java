package P05FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, String> countFormatter = list -> "Count = " + list.size();
        Function<List<Integer>, Integer> sumAllElements = list -> list.stream().reduce(0, Integer::sum);
        Function<Integer, String> sumFormatter = sum -> "Sum = " + sum;

        String countOutput = countFormatter.apply(numbers);
        System.out.println(countOutput);

        Integer sum = sumAllElements.apply(numbers);
        String sumOutput = sumFormatter.apply(sum);
        System.out.println(sumOutput);
    }
}
