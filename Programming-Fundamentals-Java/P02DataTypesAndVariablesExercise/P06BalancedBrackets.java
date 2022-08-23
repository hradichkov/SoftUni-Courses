package P02DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class P06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int closedBracket = 0;
        int openBracket = 0;

        for (int i = 0; i < n; i++) {
            String brackets = scanner.nextLine();
            if (brackets.equals(")")) {
                closedBracket++;
            } else if (brackets.equals("(")) {
                openBracket++;
            }
            if (closedBracket > openBracket) {
                System.out.println("UNBALANCED");
                return;
            }
        }
        if (closedBracket == openBracket) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
