package P04MethodsExercise;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printTopNumbers(n);
    }

    private static void printTopNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int number = i;

            for (int j = number; number > 0; j--) {
                int digit = number % 10;
                sum += digit;
                number = number / 10;
            }

            number = i;

            if (sum % 8 == 0) {
                for (int j = number; number > 0; j--) {
                    int digit = number % 10;

                    if (digit == 1 || digit == 3 || digit == 5 || digit == 7 || digit == 9) {
                        System.out.println(i);
                        break;
                    }
                    number = number / 10;
                }
            }
        }
    }
}
