package P01StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesArr = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> names = new ArrayDeque<>();

        for (String name : namesArr) {
            names.offer(name);
        }

        int cycle = 1;

        while (names.size() > 1) {
            for (int i = 1; i < n; i++) {
                names.offer(names.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + names.peek());
            } else {
                System.out.println("Removed " + names.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + names.peek());
    }

    private static boolean isPrime(int cycle) {
        if (cycle == 0 || cycle == 1) {
            return false;
        }
        if (cycle == 2) {
            return true;
        }
        if (cycle % 2 == 0) {
            return false;
        }
        return true;
    }
}
