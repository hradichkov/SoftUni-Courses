package P03Arrays;

import java.util.Scanner;

public class P02PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numberArr = new int[n];

        for (int i = 0; i < numberArr.length; i++) {
            numberArr[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = numberArr.length - 1; i >= 0; i--) {
            System.out.printf("%d ", numberArr[i]);
        }
    }
}
