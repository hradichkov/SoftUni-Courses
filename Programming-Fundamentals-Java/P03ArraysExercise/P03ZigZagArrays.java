package P03ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] firstArr = new int[n];
        int[] secondArr = new int[n];

        //int count = 0;

        for (int i = 1; i <= n; i++) {
            int[] inputArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            //count++;

            if (i % 2 != 0) {
                firstArr[i - 1] = inputArr[0];
                secondArr[i - 1] = inputArr[1];
            } else {
                secondArr[i - 1] = inputArr[0];
                firstArr[i - 1] = inputArr[1];
            }
        }

        for (int first : firstArr) {
            System.out.print(first + " ");
        }
        System.out.println();
        for (int second : secondArr) {
            System.out.print(second + " ");
        }
    }
}
