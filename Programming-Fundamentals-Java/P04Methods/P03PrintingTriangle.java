package P04Methods;

import java.util.Scanner;

public class P03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        printNumberTriangle(n);
    }

     static void printNumberTriangle(int n) {
        for (int number = 1; number <= n; number++) {
            printIncreasingNumbers(number);
        }
        for (int number = n - 1; number > 0; number--) {
            printIncreasingNumbers(number);
        }
    }

    static void printIncreasingNumbers(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
