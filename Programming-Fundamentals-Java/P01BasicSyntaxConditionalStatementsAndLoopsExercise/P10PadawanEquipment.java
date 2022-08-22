package P01BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalCost = 0;

        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightSaberPrice = Double.parseDouble(scanner.nextLine());
        double robePrice = Double.parseDouble(scanner.nextLine());
        double beltPrice = Double.parseDouble(scanner.nextLine());

        double lightSabersNeeded = Math.ceil(students + students * 0.1);
        int freeBelts = students / 6;

        totalCost = lightSabersNeeded * lightSaberPrice + students * robePrice + students * beltPrice - freeBelts * beltPrice;

        if (totalCost <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalCost);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalCost - money);
        }

    }
}
