package P03ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int longest = Integer.MIN_VALUE;
        int currentLongest = 1;
        int currentElement = 0;

        for (int i = 1; i <= array.length - 1; i++) {
            if (array[i] == array[i - 1]) {
                currentLongest++;
                if (currentLongest > longest) {
                    longest = currentLongest;
                    currentElement = array[i];
                }
            } else {
                currentLongest = 1;
            }
        }
        for (int i = 0; i < longest; i++) {
            System.out.print(currentElement + " ");
        }
    }
}
