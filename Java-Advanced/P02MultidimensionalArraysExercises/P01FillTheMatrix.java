package P02MultidimensionalArraysExercises;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String method = input[1];

        int[][] matrix = new int[n][n];
        int start = 1;

        if (method.equals("A")) {
            fillInMatrixPatternA(n, matrix, start);
        } else {
            fillInMatrixPatternB(n, matrix, start);
        }
        printMatrix(matrix, n);
    }

    private static void printMatrix(int[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillInMatrixPatternB(int n, int[][] matrix, int start) {
        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = start;
                    start++;
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = start;
                    start++;
                }
            }
        }
    }

    private static void fillInMatrixPatternA(int n, int[][] matrix, int start) {
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = start;
                start++;
            }
        }
    }
}
