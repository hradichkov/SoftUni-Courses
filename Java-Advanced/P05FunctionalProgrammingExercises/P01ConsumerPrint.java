package P05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> consumer = System.out::println;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(consumer);
    }
}
