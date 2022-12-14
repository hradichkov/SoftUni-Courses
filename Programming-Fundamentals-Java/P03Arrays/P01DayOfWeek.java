package P03Arrays;

import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] daysOfWeek = {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };

        int day = Integer.parseInt(scanner.nextLine());

        if (day < 1 || day > 7) {
            System.out.println("Invalid day!");
        } else {
            System.out.println(daysOfWeek[day - 1]);
        }
    }
}