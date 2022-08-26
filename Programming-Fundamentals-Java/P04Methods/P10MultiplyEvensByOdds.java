package P04Methods;

import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());


        if (num < 0) {
            num *= -1;
        }

        System.out.println(getMultipleOfEvensAndOdds(num));
    }

    static int getEvenSum(int num) {
        int evenSum = 0;
        for (int i = num; num > 0; i++) {
            int symbol = num % 10;

            if (symbol % 2 == 0) {
                evenSum += symbol;
            }
            num = num / 10;
        }
        return evenSum;
    }

    static int getOddSum(int num) {
        int oddSum = 0;
        for (int i = num; num > 0; i++) {
            int symbol = num % 10;

            if (symbol % 2 != 0) {
                oddSum += symbol;
            }
            num = num / 10;
        }
        return oddSum;
    }

    static int getMultipleOfEvensAndOdds(int num) {
        int evenSum = getEvenSum(num);
        int oddSum = getOddSum(num);

        return evenSum * oddSum;
    }
}