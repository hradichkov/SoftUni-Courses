package P01BasicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class P05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        area(width,length);

    }
    static int area (int width, int length){
        return width * length;
    }
}