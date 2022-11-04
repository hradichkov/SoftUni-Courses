package OldMidExams;

import java.util.Scanner;

public class P01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employee1 = Integer.parseInt(scanner.nextLine());
        int employee2 = Integer.parseInt(scanner.nextLine());
        int employee3 = Integer.parseInt(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());

        int hours = 0;
        int studentsPerHour = employee1 + employee2 + employee3;


        while (students > 0) {
            hours++;
            if (hours % 4 != 0) {
                students -= studentsPerHour;
            }
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
