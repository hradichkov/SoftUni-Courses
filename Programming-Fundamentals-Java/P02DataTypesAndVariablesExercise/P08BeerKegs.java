package P02DataTypesAndVariablesExercise;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double volume = 0;
        String biggestKeg = "";

        for (int i = 0; i < n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            //double currentVolume = Math.PI * radius * radius * height;
            double currentVolume = Math.PI * Math.pow(radius, 2) * height;


            if (currentVolume > volume) {
                volume = currentVolume;
                biggestKeg = model;
            }
        }
        System.out.printf("%s", biggestKeg);
    }
}