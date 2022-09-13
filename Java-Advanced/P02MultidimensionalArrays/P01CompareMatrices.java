package P02MultidimensionalArrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix1 = readMatrix(scanner);
        int[][] matrix2 = readMatrix(scanner);

        boolean areEqual = compareMatrices(matrix1, matrix2);
//        if (Arrays.deepEquals(matrix1, matrix2)) {
//            System.out.println("equal");
//        } else {
//            System.out.println("not equal");
//        }

        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

//        String output = areEqual ? "equal" : "not equal";
//        System.out.println(output);
    }

    private static boolean compareMatrices(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }
        for (int row = 0; row < matrix1.length; row++) {
            if (matrix1[row].length != matrix2[row].length) {
                return false;
            }
            for (int col = 0; col < matrix1[row].length; col++) {
                if (matrix1[row][col] != matrix2[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] dimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
