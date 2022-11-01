package OldExams;

import java.util.Scanner;

public class P02MouseAndCheese {

    private static int row = 0;
    private static int col = 0;
    private static int eatenCheese = 0;
    private static boolean mouseInField = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            field[i] = line.toCharArray();

            if (line.contains("M")) {
                row = i;
                col = line.indexOf("M");
            }
        }

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            switch (input) {
                case "up" -> moveMouse(field, -1, 0);
                case "down" -> moveMouse(field, 1, 0);
                case "left" -> moveMouse(field, 0, -1);
                case "right" -> moveMouse(field, 0, 1);
            }

            if (!mouseInField) {
                break;
            }

            input = scanner.nextLine();
        }

        if (!mouseInField) {
            System.out.println("Where is the mouse?");
        }

        if (eatenCheese < 5) {
            System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - eatenCheese) + " cheeses more.");
        } else {
            System.out.println("Great job, the mouse is fed " + eatenCheese + " cheeses!");
        }


        printMatrix(field);
    }

    private static void moveMouse(char[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        boolean isBonusHit = false;

        if (!isInBounds(field, nextRow, nextCol)) {
            field[row][col] = '-';
            mouseInField = false;
            return;
        }

        if (field[nextRow][nextCol] == 'c') {
            eatenCheese++;
        } else if (field[nextRow][nextCol] == 'B') {
            isBonusHit = true;
        }

        field[row][col] = '-';
        field[nextRow][nextCol] = 'M';
        row = nextRow;
        col = nextCol;

        if (isBonusHit) {
            moveMouse(field, rowMutator, colMutator);
        }
    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r < field.length && r >= 0 && c < field[r].length && c >= 0;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
