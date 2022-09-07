package P08TextProcessingExercise;

import java.util.Scanner;

public class P02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String input1 = input[0];
        String input2 = input[1];

        int sum = getSum(input1, input2);
        System.out.println(sum);
    }

    private static int getSum(String input1, String input2) {
        int sum = 0;
        int difference = Math.abs(input1.length() - input2.length());

        if (input1.length() >= input2.length()) {
            for (int i = 0; i < input2.length(); i++) {
                sum += input1.charAt(i) * input2.charAt(i);
            }

            for (int i = input1.length() - 1; i >= input1.length() - difference; i--) {
                sum += input1.charAt(i);
            }
        } else {
            for (int i = 0; i < input1.length(); i++) {
                sum += input1.charAt(i) * input2.charAt(i);
            }

            for (int i = input2.length() - 1; i >= input2.length() - difference; i--) {
                sum += input2.charAt(i);
            }
        }
        return sum;
    }
}
