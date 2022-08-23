package P02DataTypesAndVariables;

import java.util.Scanner;

public class P06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String char1 = scanner.nextLine();
//        String char2 = scanner.nextLine();
//        String char3 = scanner.nextLine();

        char char1 = scanner.nextLine().charAt(0);
        char char2 = scanner.nextLine().charAt(0);
        char char3 = scanner.nextLine().charAt(0);

        System.out.printf("%c%c%c", char1, char2, char3);
    }
}
