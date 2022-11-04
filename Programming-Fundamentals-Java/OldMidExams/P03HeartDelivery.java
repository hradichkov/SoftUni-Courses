package OldMidExams;

import java.util.Arrays;
import java.util.Scanner;

public class P03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("@")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        int currentPosition = 0;
        int count = 0;

        while (!input.equals("Love!")) {
            String[] data = input.split(" ");
            int length = Integer.parseInt(data[1]);
            currentPosition += length;

            if (currentPosition > array.length - 1) {
                currentPosition = 0;
            }
            if (array[currentPosition] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", currentPosition);
            } else {
                array[currentPosition] -= 2;
                if (array[currentPosition] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentPosition);
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", currentPosition);
        printSuccessfulOrFailed(array, count);
    }

    private static void printSuccessfulOrFailed(int[] array, int count) {
        for (int j : array) {
            if (j != 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", count);
        }
    }
}
