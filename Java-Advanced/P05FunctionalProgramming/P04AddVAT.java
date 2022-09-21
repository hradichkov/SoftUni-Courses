package P05FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> addVAT = p -> p * 1.2;
        Consumer<Double> printer = n -> System.out.printf("%.2f%n", n);

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(addVAT)
                .forEach(printer);
    }
}
