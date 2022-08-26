package P04Methods;

import java.util.Scanner;

public class P01SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //int n = Integer.parseInt(scanner.nextLine());

        printSign(Integer.parseInt(scanner.nextLine()));
    }

    static void printSign(int number) {
        if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        } else if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        } else {
            System.out.print("The number 0 is zero.");
        }
    }
}
