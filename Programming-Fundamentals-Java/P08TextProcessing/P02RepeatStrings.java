package P08TextProcessing;

import java.util.Arrays;
import java.util.Scanner;

public class P02RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] array = scanner.nextLine().split(" ");

        for (String s : array) {
            for (int i = 0; i < s.length(); i++) {
                System.out.print(s);
            }
        }
    }
}
