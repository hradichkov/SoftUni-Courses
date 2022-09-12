package P01StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] numbers = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String num : numbers) {
            stack.push(Integer.parseInt(num));
        }
        for (Integer num : stack) {
            System.out.printf("%s ", stack.pop());
        }
    }
}
