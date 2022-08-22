package P01BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P02Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int divisibleBy = 0;

        if (num % 10 == 0) {
            divisibleBy = 10;
        } else if (num % 7 == 0) {
            divisibleBy = 7;
        } else if (num % 6 == 0) {
            divisibleBy = 6;
        } else if (num % 3 == 0) {
            divisibleBy = 3;
        }else if (num % 2 == 0) {
            divisibleBy = 2;
        }
        if (divisibleBy == 0) {
            System.out.println("Not divisible");
        } else {
            System.out.printf("The number is divisible by %d", divisibleBy);
        }
    }
}
