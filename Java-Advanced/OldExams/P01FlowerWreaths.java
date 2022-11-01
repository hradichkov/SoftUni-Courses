package OldExams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>(); // stack

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(lilies::push);

        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // queue

        int wreaths = 0;
        int sumOfLeftFlowers = 0;

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int rose = roses.poll();
            int lily = lilies.pop();

            int sum = lily + rose;

            while (sum > 15) {
                lily = lily - 2;
                sum = lily + rose;
            }

            if (sum == 15) {
                wreaths++;
            } else {
                sumOfLeftFlowers += sum;
            }
        }
        wreaths += sumOfLeftFlowers / 15;

        if (wreaths < 5) {
            System.out.println("You didn't make it, you need " + (5 - wreaths) + " wreaths more!");
        } else {
            System.out.println("You made it, you are going to the competition with " + wreaths + " wreaths!");
        }
    }
}