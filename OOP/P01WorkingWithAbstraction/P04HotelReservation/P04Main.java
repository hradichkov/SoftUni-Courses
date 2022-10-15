package P01WorkingWithAbstraction.P04HotelReservation;

import java.util.Scanner;

public class P04Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(data[0]);
        int days = Integer.parseInt(data[1]);
        P04Season season = P04Season.parse(data[2]);
        P04Discount discount = P04Discount.parse(data[3]);

        P04PriceCalculator calculator = new P04PriceCalculator(pricePerDay, days, season, discount);
        System.out.printf("%.2f", calculator.calculatePrice());
    }
}
