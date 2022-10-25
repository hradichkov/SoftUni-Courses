package P05PolymorphismExercises.P01Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        double carFuelQuantity = Double.parseDouble(data[1]);
        double carFuelConsumption = Double.parseDouble(data[2]);

        Vehicle car = new Car(carFuelQuantity, carFuelConsumption);

        data = scanner.nextLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(data[1]);
        double truckFuelConsumption = Double.parseDouble(data[2]);

        Vehicle truck = new Truck(truckFuelQuantity, truckFuelConsumption);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            data = scanner.nextLine().split("\\s+");

            String commandName = data[0];
            String vehicleType = data[1];

            switch (commandName) {
                case "Drive" -> {
                    double distance = Double.parseDouble(data[2]);
                    String driveMessage = vehicles.get(vehicleType).drive(distance);
                    System.out.println(driveMessage);
                }
                case "Refuel" -> {
                    double fuelAmount = Double.parseDouble(data[2]);
                    vehicles.get(vehicleType).refuel(fuelAmount);
                }
            }
        }
        vehicles.values().forEach(System.out::println);
    }
}
