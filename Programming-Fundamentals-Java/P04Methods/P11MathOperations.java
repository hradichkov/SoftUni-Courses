package P04Methods;

import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int num2 = Integer.parseInt(scanner.nextLine());

        double result = calculate(num1, operator, num2);

        System.out.printf("%.0f", result);
    }

    static double calculate(int num1, String operator, int num2) {
        double result = 0;

        if (operator.equals("+")) {
            result = num1 + num2;
        } else if (operator.equals("-")) {
            result = num1 - num2;
        } else if (operator.equals("/")) {
            result = num1 * 1.0 / num2;
        } else {
            result = num1 * num2;
        }
        return result;
    }
}
