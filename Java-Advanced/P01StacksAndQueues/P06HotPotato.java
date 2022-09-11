package P01StacksAndQueues;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesArr = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> names = new ArrayDeque<>();

        for (String name : namesArr) {
            names.offer(name);
        }

        while (names.size() > 1) {
            for (int i = 1; i < n; i++) {
                names.offer(names.poll());
            }
            System.out.println("Removed " + names.poll());
        }
        System.out.println("Last is " + names.peek());
    }
}
