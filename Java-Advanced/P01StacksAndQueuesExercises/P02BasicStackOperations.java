package P01StacksAndQueuesExercises;

import java.text.CollationElementIterator;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] operations = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int countToPush = operations[0];
        int countToPop = operations[1];
        int elementToSearch = operations[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < countToPush; i++) {
            stack.push(numbers[i]);
        }
        for (int i = 0; i < countToPop; i++) {
            stack.pop();
        }

        if (stack.contains(elementToSearch)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(stack));
                //System.out.println(stack.stream().mapToInt(e->e).min().getAsInt());
                //System.out.println(stack.stream().min(Integer::compare).get());
            }
        }
    }
}
