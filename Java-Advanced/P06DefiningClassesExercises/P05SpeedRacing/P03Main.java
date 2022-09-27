package P06DefiningClassesExercises.P05SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, P03Car> cars = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(" ");
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fuelCost = Double.parseDouble(data[2]);

            P03Car car = new P03Car(model, fuelAmount, fuelCost);
            cars.put(model, car);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split(" ");
            String model = data[1];
            int km = Integer.parseInt(data[2]);

            double fuelAmount = cars.get(model).getFuelAmount();
            double fuelCost = cars.get(model).getFuelCost();

//            if (fuelCost * km <= fuelAmount) {
//                cars.get(model).setDistance(cars.get(model).getDistance() + km);
//                cars.get(model).setFuelAmount(cars.get(model).getFuelAmount() - fuelCost * km);
//            } else {
//                System.out.println("Insufficient fuel for the drive");
//            }

            if (!cars.get(model).hasEnoughFuel(km)) {
                System.out.println("Insufficient fuel for the drive");
            } else {
                cars.get(model).drive(km);
            }
            input = scanner.nextLine();
        }
//        cars.entrySet().stream()
//                .forEach(car -> System.out.printf("%s %.2f %d%n", car.getKey(), car.getValue().getFuelAmount(), car.getValue().getDistance()));

        cars.values()
                .forEach(System.out::println);
    }
}
