package P02MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;

        for (int row = 0; row < n; row++) {
            primaryDiagonalSum += matrix[row][row];
            secondaryDiagonalSum += matrix[n - 1 - row][row];
        }
//        for (int row = n - 1, col = 0; row >= 0; row--, col++) {
//            secondaryDiagonalSum += matrix[row][col];
//
//        }
        int difference = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
        System.out.println(difference);
    }
}
