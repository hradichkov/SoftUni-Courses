package P02DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P02SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;

//        for (int i = 0; num > 0; i++) {
//            sum += num % 10;
//            num = num / 10;
//        }

        while (num > 0) { // while (n != 0)
            sum += num % 10;
            num = num / 10;
        }
        System.out.println(sum);
    }
}
