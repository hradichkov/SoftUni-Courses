package P04MethodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        int smallestNum = readSmallestNum(n1, n2, n3);

        System.out.println(smallestNum);
    }

    static int readSmallestNum(int n1, int n2, int n3) {
        int[] num = {n1, n2, n3};
        Arrays.sort(num);
        return num[0];
    }
}
