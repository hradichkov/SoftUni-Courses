package P03Arrays;

import java.util.Scanner;

public class P04ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] inputArr = scanner.nextLine().split(" ");

        for (int i = 0; i < inputArr.length / 2; i++) {
            String old = inputArr[i];

            inputArr[i] = inputArr[inputArr.length - 1 - i];

            inputArr[inputArr.length - 1 - i] = old;
        }
        System.out.print(String.join(" ", inputArr));
    }
}
