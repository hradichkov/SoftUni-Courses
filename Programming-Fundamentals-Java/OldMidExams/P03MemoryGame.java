package OldMidExams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elementsList = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        int count = 0;

        while (!input.equals("end")) {
            List<String> data = Arrays.stream(input.split(" ")).toList();
            int index1 = Integer.parseInt(data.get(0));
            int index2 = Integer.parseInt(data.get(1));
            count++;

            if (data.get(0).equals(data.get(1)) || index1 < 0 || index1 >= elementsList.size() || index2 < 0 || index2 >= elementsList.size()) {
                elementsList.add(elementsList.size() / 2, "-" + count + "a");
                elementsList.add(elementsList.size() / 2, "-" + count + "a");

                System.out.println("Invalid input! Adding additional elements to the board");
            } else if (elementsList.get(index1).equals(elementsList.get(index2))) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", elementsList.get(index1));
                String elementOne = elementsList.get(index1);
                String elementTwo = elementsList.get(index2);

                elementsList.remove(elementOne);
                elementsList.remove(elementTwo);
            } else {
                System.out.println("Try again!");
            }

            if (elementsList.size() == 0) {
                System.out.printf("You have won in %d turns!", count);
                break;
            }

            input = scanner.nextLine();
        }
        if (elementsList.size() != 0) {
            System.out.println("Sorry you lose :(");
            for (String element : elementsList) {
                System.out.print(element + " ");
            }
        }
    }
}
