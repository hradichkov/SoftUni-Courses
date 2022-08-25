package P03ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean noIndex = true;

        for (int i = 0; i < array.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = i + 1; j < array.length; j++) {
                rightSum += array[j];
            }
            for (int j = i - 1; j >= 0; j--) {
                leftSum += array[j];
            }

            if (leftSum == rightSum) {
                System.out.println(i);
                noIndex = false;
            }
        }
        if (noIndex) {
            System.out.println("no");
        }
    }
}
