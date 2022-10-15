package P01WorkingWithAbstraction.P02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinates = getCoordinates(scanner);

        Point a = new Point(coordinates[0], coordinates[1]);
        Point c = new Point(coordinates[2], coordinates[3]);
        Rectangle rectangle = new Rectangle(a, c);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int[] pointsCoordinates = getCoordinates(scanner);

            Point x = new Point(pointsCoordinates[0], pointsCoordinates[1]);

            boolean isInside = rectangle.contains(x);
            System.out.println(isInside);
        }
    }

    private static int[] getCoordinates(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
