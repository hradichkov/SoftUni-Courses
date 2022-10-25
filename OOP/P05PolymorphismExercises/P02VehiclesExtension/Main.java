package P05PolymorphismExercises.P02VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        double carFuelQuantity = Double.parseDouble(data[1]);
        double carFuelConsumption = Double.parseDouble(data[2]);
        double carTankCapacity = Double.parseDouble(data[3]);

        Vehicle car = new Car(carFuelQuantity, carFuelConsumption, carTankCapacity);

        data = scanner.nextLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(data[1]);
        double truckFuelConsumption = Double.parseDouble(data[2]);
        double truckTankCapacity = Double.parseDouble(data[3]);

        Vehicle truck = new Truck(truckFuelQuantity, truckFuelConsumption, truckTankCapacity);

        data = scanner.nextLine().split(" ");
        double busFuelQuantity = Double.parseDouble(data[1]);
        double busFuelConsumption = Double.parseDouble(data[2]);
        double busTankCapacity = Double.parseDouble(data[3]);

        Vehicle bus = new Bus(busFuelQuantity, busFuelConsumption, busTankCapacity);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            data = scanner.nextLine().split("\\s+");

            String commandName = data[0];
            String vehicleType = data[1];

            switch (commandName) {
                case "Drive" -> {
                    double distance = Double.parseDouble(data[2]);
                    Vehicle vehicle = vehicles.get(vehicleType);
                    if (vehicle instanceof Bus) {
                        vehicle.setFuelConsumption(vehicle.getFuelConsumption() + Bus.ADDITIONAL_FULL_BUS_CONSUMPTION);
                        System.out.println(vehicle.drive(distance));
                        vehicle.setFuelConsumption(vehicle.getFuelConsumption() - Bus.ADDITIONAL_FULL_BUS_CONSUMPTION);
                        continue;
                    }
                    String driveMessage = vehicle.drive(distance);
                    System.out.println(driveMessage);
                }
                case "Refuel" -> {
                    double fuelAmount = Double.parseDouble(data[2]);
                    vehicles.get(vehicleType).refuel(fuelAmount);
                }
                case "DriveEmpty" -> {
                    double driveEmptyDistance = Double.parseDouble(data[2]);
                    String driveEmptyMessage = bus.drive(driveEmptyDistance);
                    System.out.println(driveEmptyMessage);
                }
            }
        }
        vehicles.values().forEach(System.out::println);
    }
}
