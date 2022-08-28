package P04MethodsExercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        printFactorialDivision(n1, n2);
    }

    private static void printFactorialDivision(int n1, int n2) {
        long sum1 = 1;
        long sum2 = 1;

        for (int i = 1; i <= n1; i++) {
            sum1 *= i;
        }
        for (int i = 1; i <= n2; i++) {
            sum2 *= i;
        }

        double result = sum1 * 1.0 / sum2;

        System.out.printf("%.2f", result);
    }
}
