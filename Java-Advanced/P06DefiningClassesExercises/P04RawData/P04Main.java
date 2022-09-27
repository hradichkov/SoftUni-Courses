package P06DefiningClassesExercises.P04RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<P04Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(" ");
            String carModel = data[0];

            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            P04Engine engine = new P04Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            P04Cargo cargo = new P04Cargo(cargoWeight, cargoType);

            List<P04Tire> tires = new ArrayList<>();
            for (int i = 5; i < data.length; i += 2) {
                double tirePressure = Double.parseDouble(data[i]);
                int tireAge = Integer.parseInt(data[i + 1]);
                P04Tire tire = new P04Tire(tirePressure, tireAge);

                tires.add(tire);
            }
            P04Car car = new P04Car(carModel, engine, cargo, tires);
            cars.add(car);
        }
        String cargoType = scanner.nextLine();

        if (cargoType.equals("fragile")) {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals("fragile"))
                    .filter(car -> car.getTires().stream().anyMatch(tire -> tire.getPressure() < 1))
                    .forEach(car -> System.out.println(car.getModel()));
        } else {
            cars.stream()
                    .filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }
}
