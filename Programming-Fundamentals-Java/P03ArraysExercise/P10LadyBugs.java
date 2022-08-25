package P03ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P10LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        int[] field = new int[fieldSize];
        int[] indexesOfLadybugs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < indexesOfLadybugs.length; i++) {
            if (indexesOfLadybugs[i] >= 0 && indexesOfLadybugs[i] < field.length)
                field[indexesOfLadybugs[i]] = 1;
        }
//        for (int bugPosition : indexesOfLadybugs){
//            field[bugPosition] = 1;
//        }
        String input = scanner.nextLine();

         while (!input.equals("end")) {
            String[] data = input.split(" ");
            int index = Integer.parseInt(data[0]);
            String direction = data[1];
            int flyLength = Integer.parseInt(data[2]);

            if (index < 0 || index >= field.length || field[index] != 1) {
                input = scanner.nextLine();
                continue;
            }

            field[index] = 0;

            if (direction.equals("right")) {
                index += flyLength;

                while (index < fieldSize && field[index] == 1) {
                    index += flyLength;
                }

                if (index < fieldSize) {
                    field[index] = 1;
                }

            } else {
                index -= flyLength;

                while (index >= 0 && field[index] == 1) {
                    index -= flyLength;
                }

                if (index >= 0) {
                    field[index] = 1;
                }

            }
            input = scanner.nextLine();
        }
        Arrays.stream(field).forEach(e -> System.out.print(e + " "));
    }
}
