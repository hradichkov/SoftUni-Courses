package P02DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int liters = Integer.parseInt(scanner.nextLine());

            if (sum + liters > 255) {
                System.out.println("Insufficient capacity!");
                continue;
            }
            sum += liters;
        }
        System.out.printf("%d", sum);
    }
}
