package P04MethodsExercise;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char symbol1 = scanner.nextLine().charAt(0);
        char symbol2 = scanner.nextLine().charAt(0);

        printCharactersBetween(symbol1, symbol2);

    }

    private static void printCharactersBetween(char symbol1, char symbol2) {
//        if (symbol1 > symbol2){
//            char temp = symbol1;
//            symbol1 = symbol2;
//            symbol2 = temp;
//        }
        if (symbol1 < symbol2) {
            for (int i = symbol1 + 1; i < symbol2; i++) {
                System.out.printf("%c ", i);
            }
        } else {
            for (int i = symbol2 + 1; i < symbol1; i++) {
                System.out.printf("%c ", i);
            }
        }
    }
}
