package P07GenericsExercises.P03GenericCountMethod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box<>();

        for (int i = 0; i < n; i++) {
            Double input = Double.parseDouble(scanner.nextLine());

            box.add(input);
        }
        Double elementToCompare = Double.parseDouble(scanner.nextLine());

        int count = box.count(elementToCompare);

        System.out.println(count);
    }
}
