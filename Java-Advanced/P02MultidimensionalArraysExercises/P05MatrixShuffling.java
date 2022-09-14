package P02MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
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

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            if (isValidCommand(input, rows, cols)) {
                String[] data = input.split("\\s+");

                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                int firstEl = matrix[row1][col1];
                int secondEl = matrix[row2][col2];

                matrix[row1][col1] = secondEl;
                matrix[row2][col2] = firstEl;

                printMatrix(matrix, rows, cols);
            } else {
                System.out.println("Invalid data!");
            }
            input = scanner.nextLine();
        }
    }

    private static boolean isValidCommand(String input, int rows, int cols) {
        String[] data = input.split("\\s+");

        if (!data[0].equals("swap")) {
            return false;
        }
        if (data.length != 5) {
            return false;
        }

        int row1 = Integer.parseInt(data[1]);
        int col1 = Integer.parseInt(data[2]);
        int row2 = Integer.parseInt(data[3]);
        int col2 = Integer.parseInt(data[4]);

        if (row1 < 0 || row1 > rows || col1 < 0 || col1 > cols
                || row2 < 0 || row2 > rows || col2 < 0 || col2 > cols) {
            return false;
        }
        return true;
    }

    private static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
