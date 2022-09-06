package P08TextProcessing;

import java.util.Scanner;

public class P03Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String toRemove = scanner.nextLine();
        String input = scanner.nextLine();

        while (input.contains(toRemove)) {
            input = input.replace(toRemove, "");
        }
        System.out.println(input);
    }
}
