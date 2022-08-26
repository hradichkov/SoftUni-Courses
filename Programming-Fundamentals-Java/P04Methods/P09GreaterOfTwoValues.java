package P04Methods;

import java.util.Scanner;

public class P09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int a = Integer.parseInt(scanner.nextLine());
                int b = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(a, b));
                break;
            case "string":
                String word1 = scanner.nextLine();
                String word2 = scanner.nextLine();
                System.out.println(getMax(word1, word2));
                break;
            case "char":
                char symbol1 = scanner.nextLine().charAt(0);
                char symbol2 = scanner.nextLine().charAt(0);
                System.out.println(getMax(symbol1, symbol2));
                break;
        }
    }

    private static int getMax(int a, int b) {

        return Math.max(a, b);
    }

    private static String getMax(String word1, String word2) {
        if (word1.compareTo(word2) >= 0) {
            return word1;
        }
        return word2;
    }

    private static char getMax(char symbol1, char symbol2) {
        if (symbol1 > symbol2) {
            return symbol1;
        }
        return symbol2;
    }
}
