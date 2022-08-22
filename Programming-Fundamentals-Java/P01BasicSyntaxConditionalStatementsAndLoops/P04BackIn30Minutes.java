package P01BasicSyntaxConditionalStatementsAndLoops;

import java.util.Scanner;

public class P04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int min = Integer.parseInt(scanner.nextLine());

        min += 30;

        if (min > 59) {
            hour++;
            min -= 60;
            if (hour == 24) {
                hour = 0;
            }
        }
        System.out.printf("%d:%02d", hour, min);
    }
}
