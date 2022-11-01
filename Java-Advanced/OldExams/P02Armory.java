package OldExams;

import java.util.Scanner;

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        int officerRow = 0;
        int officerCol = 0;

        int firstMirrorRow = -1;
        int firstMirrorCol = -1;

        int secondMirrorRow = -1;
        int secondMirrorCol = -1;

        int coins = 0;

        boolean outOfBounds = false;

        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();

            field[i] = line.toCharArray();

            for (int j = 0; j < size; j++) {
                char currentChar = line.charAt(j);
                if (currentChar == 'M' && firstMirrorRow == -1) {
                    firstMirrorRow = i;
                    firstMirrorCol = j;
                } else if (currentChar == 'M') {
                    secondMirrorRow = i;
                    secondMirrorCol = j;
                }
            }

            if (line.contains("A")) {
                officerRow = i;
                officerCol = line.indexOf("A");
            }
        }


        while (coins < 65) {
            String command = scanner.nextLine();

            int lastRow = officerRow;
            int lastCol = officerCol;

            switch (command) {
                case "up" -> officerRow--;
                case "down" -> officerRow++;
                case "left" -> officerCol--;
                case "right" -> officerCol++;
            }
            field[lastRow][lastCol] = '-';

            if (isInBounds(field, officerRow, officerCol)) {
                char currentChar = field[officerRow][officerCol];
                if (Character.isDigit(currentChar)) {
                    coins += Character.getNumericValue(currentChar);
                } else if (currentChar == 'M') {
                    if (officerRow == firstMirrorRow && officerCol == firstMirrorCol) {
                        officerRow = secondMirrorRow;
                        officerCol = secondMirrorCol;
                    } else {
                        officerRow = firstMirrorRow;
                        officerCol = firstMirrorCol;
                    }
                    field[firstMirrorRow][firstMirrorCol] = '-';
                    field[secondMirrorRow][secondMirrorCol] = '-';
                }

                field[officerRow][officerCol] = 'A';
            } else {
                System.out.println("I do not need more swords!");
                outOfBounds = true;
                break;
            }

        }

        if (!outOfBounds) {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.println("The king paid " + coins + " gold coins.");

        printMatrix(field);
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
