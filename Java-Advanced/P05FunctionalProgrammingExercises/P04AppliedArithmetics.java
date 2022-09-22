package P05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> add = numList -> numList.stream().map(e -> e + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = numList -> numList.stream().map(e -> e * 2).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = numList -> numList.stream().map(e -> e - 1).collect(Collectors.toList());
        Consumer<Integer> printer = e -> System.out.print(e + " ");


        String input = scanner.nextLine();

        while (!input.equals("end")) {
            switch (input) {
                case "add" -> numbers = add.apply(numbers);
                case "multiply" -> numbers = multiply.apply(numbers);
                case "subtract" -> numbers = subtract.apply(numbers);
                case "print" -> {
                    numbers.forEach(printer);
                    System.out.println();
                }
            }
            input = scanner.nextLine();
        }
    }
}
