package P02DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class P03FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = Double.parseDouble(scanner.nextLine());
        double num2 = Double.parseDouble(scanner.nextLine());

        double eps = 0.000001;

        if (Math.abs(num1 - num2) >= eps) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
