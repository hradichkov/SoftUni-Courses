package OldExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02Bomb2 {
    private static int row = 0;
    private static int col = 0;
    private static int bombs = 0;
    private static boolean end = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        String[] commands = scanner.nextLine().split(",");

        for (int i = 0; i < size; i++) {
            List<Character> line = Arrays.stream(scanner.nextLine().split(" "))
                    .map(e -> e.charAt(0)).toList();

            for (int j = 0; j < line.size(); j++) {
                field[i][j] = line.get(j);
                if (field[i][j] == 'B') {
                    bombs++;
                }
            }
            if (line.contains('s')) {
                row = i;
                col = line.indexOf('s');
            }
        }

        for (String currentCommand : commands) {
            switch (currentCommand) {
                case "up" -> moveSapper(field, -1, 0);
                case "down" -> moveSapper(field, 1, 0);
                case "left" -> moveSapper(field, 0, -1);
                case "right" -> moveSapper(field, 0, 1);
            }
            if (end) {
                System.out.printf("END! %d bombs left on the field%n", bombs);
                break;
            }
            if (bombs == 0) {
                break;
            }
        }

        if (!end) {
            if (bombs == 0) {
                System.out.println("Congratulations! You found all bombs!");
            } else {
                System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs, row, col);
            }
        }
    }

    private static void moveSapper(char[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        if (isInBounds(field, nextRow, nextCol)) {
            if (field[nextRow][nextCol] == 'B') {
                bombs--;
                System.out.println("You found a bomb!");
            } else if (field[nextRow][nextCol] == 'e') {
                end = true;
                return;
            }

            field[row][col] = '+';
            field[nextRow][nextCol] = 's';
            row = nextRow;
            col = nextCol;
        }
    }

    private static boolean isInBounds(char[][] field, int r, int c) {
        return r < field.length && r >= 0 && c < field[r].length && c >= 0;
    }
}

