package P04Methods;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String repeated = repeatString(input, n);

        System.out.print(repeated);
    }

    private static String repeatString(String input, int n) {
        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            array[i] = input;
        }

        String repeated = String.join("", array);
        return repeated;
    }
}

//    static void repeatString(String input, int n) {
//        for (int i = 0; i < n; i++) {
//            System.out.print(input);
//        }
//    }


