package P01BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int num = Integer.parseInt(input);
        int number = num;
        int sum = 1;
        int totalSum = 0;

        for (int i = 0; i < input.length(); i++) {

            int digit = num % 10;
            num /= 10;

            sum = 1;

            for (int j = digit; j >= 1; j--) {
                sum *= j;
            }

            totalSum += sum;

        }

        if (totalSum == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
