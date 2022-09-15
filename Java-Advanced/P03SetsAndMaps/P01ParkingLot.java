package P03SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashSet<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] data = input.split(", ");
            String command = data[0];
            String carNumber = data[1];

            switch (command) {
                case "IN":
                    cars.add(carNumber);
                    break;
                case "OUT":
                    cars.remove(carNumber);
                    break;
            }
            input = scanner.nextLine();
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumber : cars) {
                System.out.println(carNumber);
            }
            //System.out.println(String.join(System.lineSeparator(), cars));
        }
    }
}
