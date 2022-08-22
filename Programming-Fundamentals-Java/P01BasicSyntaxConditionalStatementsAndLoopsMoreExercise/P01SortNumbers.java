package P01BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        int[] num = {n1, n2, n3};
        Arrays.sort(num);

        for (int i = num.length - 1; i >= 0; i--) {
            System.out.println(num[i]);
        }
    }
}

