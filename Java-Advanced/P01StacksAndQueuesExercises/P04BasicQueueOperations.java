package P01StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] operations = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int countToOffer = operations[0];
        int countToPoll = operations[1];
        int elementToSearch = operations[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < countToOffer; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i < countToPoll; i++) {
            queue.poll();
        }

        if (queue.contains(elementToSearch)) {
            System.out.println("true");
        } else {
            if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(queue));
                //System.out.println(stack.stream().mapToInt(e->e).min().getAsInt());
                //System.out.println(stack.stream().min(Integer::compare).get());
            }
        }
    }
}
