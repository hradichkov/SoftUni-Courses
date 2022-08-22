package P01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P09SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.println(1 + i * 2);
            sum += 1 + i * 2;
        }
        System.out.printf("Sum: %d", sum);
    }
}
