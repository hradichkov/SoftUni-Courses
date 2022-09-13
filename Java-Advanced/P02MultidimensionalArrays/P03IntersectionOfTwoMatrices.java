package P02MultidimensionalArrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(scanner, rows, cols);
        char[][] secondMatrix = readMatrix(scanner, rows, cols);

        char[][] outputMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
//                if (firstMatrix[row][col] == secondMatrix[row][col]) {
//                    System.out.print(firstMatrix[row][col] + " ");
//                } else {
//                    System.out.print("* ");
//                }
                outputMatrix[row][col] = firstMatrix[row][col] == secondMatrix[row][col] ? firstMatrix[row][col] : '*';
            }
            //System.out.println();
        }
        for (char[] matrix : outputMatrix) {
            for (char c : matrix) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] arr = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[row] = arr;
        }
        return matrix;
    }
}
