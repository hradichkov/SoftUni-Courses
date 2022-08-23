package P02DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            int sum = 0;
            double num1 = Double.parseDouble(array[0]);
            double num2 = Double.parseDouble(array[1]);

            double biggerNum;
            if (num1 > num2) {
                biggerNum = Math.abs(num1);
            } else {
                biggerNum = Math.abs(num2);
            }
            while (biggerNum > 0) {
                sum += biggerNum % 10;
                biggerNum = biggerNum / 10;
            }
            System.out.println(Math.abs(sum));
        }
    }
}
