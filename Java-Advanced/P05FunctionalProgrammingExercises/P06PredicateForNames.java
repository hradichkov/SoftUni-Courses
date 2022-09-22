package P05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Predicate<String> predicate = name -> name.length() <= n;

        Arrays.stream(scanner.nextLine().split(" "))
                .filter(predicate)
                .forEach(System.out::println);
    }
}
