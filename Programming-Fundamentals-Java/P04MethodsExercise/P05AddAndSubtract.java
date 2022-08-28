package P04MethodsExercise;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        int sum = sum(n1, n2);
        int subtract = subtract(sum, n3);

        System.out.println(subtract);
    }

    private static int subtract(int sum, int n3) {
        return sum - n3;
    }

    private static int sum(int n1, int n2) {
        return n1 + n2;
    }
}
