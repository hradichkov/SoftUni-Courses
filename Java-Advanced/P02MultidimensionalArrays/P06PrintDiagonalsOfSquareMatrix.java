package P02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int[][] diagonalMatrix = new int[2][n];
        // for (int row = 0; row < 1; row++) {
        for (int col = 0; col < n; col++) {
            diagonalMatrix[0][col] = matrix[col][col];
            diagonalMatrix[1][col] = matrix[n - 1 - col][col];
        }
        // }
        printMatrix(diagonalMatrix);
    }

    private static void printMatrix(int[][] diagonalMatrix) {
        for (int[] matrix : diagonalMatrix) {
            for (int num : matrix) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
