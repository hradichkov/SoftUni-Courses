package P03ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < array.length; i++) {
            boolean topInteger = true;
            for (int j = 1 + i; j < array.length; j++) {
                if (array[i] <= array[j]) {
                    topInteger = false;
                    break;
                }
            }
            if (topInteger) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
