package P02MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }

        int[][] resultMatrix = new int[3][3];
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    resultMatrix = new int[][]{{matrix[row][col], matrix[row][col + 1], matrix[row][col + 2]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1], matrix[row + 1][col + 2]},
                            {matrix[row + 2][col], matrix[row + 2][col + 1], matrix[row + 2][col + 2]}};
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int[] numbers : resultMatrix) {
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
