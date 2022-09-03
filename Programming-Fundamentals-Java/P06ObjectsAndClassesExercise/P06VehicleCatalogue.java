package P06ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06VehicleCatalogue {

    static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsepower;

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        public String getType() {
            return this.type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double carHorsepower = 0;
        int cars = 0;
        double truckHorsepower = 0;
        int trucks = 0;


        List<Vehicle> vehicleList = new ArrayList<>();

        while (!input.equals("End")) {
            String type = input.split(" ")[0];
            String model = input.split(" ")[1];
            String color = input.split(" ")[2];
            int horsepower = Integer.parseInt(input.split(" ")[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehicleList.add(vehicle);

            if (type.equals("car")) {
                carHorsepower += horsepower;
                cars++;
            } else {
                truckHorsepower += horsepower;
                trucks++;
            }

            input = scanner.nextLine();
        }

        String model = scanner.nextLine();

        while (!model.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicleList) {
                if (vehicle.getModel().equals(model)) {
                    if (vehicle.getType().equals("car")) {
                        System.out.println("Type: Car");
                    } else {
                        System.out.println("Type: Truck");
                    }
                    System.out.printf("Model: %s%n", vehicle.getModel());
                    System.out.printf("Color: %s%n", vehicle.getColor());
                    System.out.printf("Horsepower: %s%n", vehicle.getHorsepower());
                    break;
                }
            }
            model = scanner.nextLine();
        }

        if (carHorsepower / cars > 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n", carHorsepower / cars);
        } else {
            System.out.println("Cars have average horsepower of: 0.00.");
        }

        if (truckHorsepower / trucks > 0) {
            System.out.printf("Trucks have average horsepower of: %.2f.", truckHorsepower / trucks);
        } else {
            System.out.println("Trucks have average horsepower of: 0.00.");
        }
    }
}
