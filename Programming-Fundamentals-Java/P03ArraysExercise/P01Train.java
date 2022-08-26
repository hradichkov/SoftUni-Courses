package P03ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        int[] nArr = new int[n];

        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(scanner.nextLine());
            System.out.printf("%d ", nArr[i]);
            sum += nArr[i];
        }

        System.out.printf("%n%d", sum);
    }
}
