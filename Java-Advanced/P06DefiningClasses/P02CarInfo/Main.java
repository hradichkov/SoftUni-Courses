package P06DefiningClasses.P02CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String brand = data[0];
            String model = data[1];
            int horsePower = Integer.parseInt(data[2]);

            Car car = new Car(brand, model, horsePower);
            System.out.println(car.carInfo());
        }
    }
}
