package OldExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        String[] commands = scanner.nextLine().split(",");

        int bombs = 0;
        int foundBombs = 0;

        int sapperRow = 0;
        int sapperCol = 0;

        for (int row = 0; row < size; row++) {
            List<Character> line = Arrays.stream(scanner.nextLine().split(" "))
                    .map(e -> e.charAt(0)).toList();

            //char[] line = scanner.nextLine().replaceAll(" ", "").toCharArray();

            for (int col = 0; col < line.size(); col++) {
                char currentChar = line.get(col);

                if (currentChar == 'B') {
                    bombs++;
                } else if (currentChar == 's') {
                    sapperRow = row;
                    sapperCol = col;
                }
                field[row][col] = currentChar;
            }

//            for (int col = 0; col < line.size(); col++) {
//                field[row][col] = line.get(col);
//                if (field[row][col] == 'B') {
//                    bombs++;
//                }
//            }
//            if (line.contains('s')) {
//                sapperRow = row;
//                sapperCol = line.indexOf('s');
//            }
        }

        for (String currentCommand : commands) {
            switch (currentCommand) {
                case "up":
                    if (sapperRow != 0) {
                        sapperRow--;
                    }
                    break;
                case "down":
                    if (sapperRow != size - 1) {
                        sapperRow++;
                    }
                    break;
                case "left":
                    if (sapperCol != 0) {
                        sapperCol--;
                    }
                    break;
                case "right":
                    if (sapperCol != size - 1) {
                        sapperCol++;
                    }
                    break;
            }

            if (field[sapperRow][sapperCol] == 'B') {
                System.out.println("You found a bomb!");
                foundBombs++;
                field[sapperRow][sapperCol] = '+';

                if (bombs == foundBombs) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }

            } else if (field[sapperRow][sapperCol] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", bombs - foundBombs);
                return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombs - foundBombs, sapperRow, sapperCol);
    }
}
