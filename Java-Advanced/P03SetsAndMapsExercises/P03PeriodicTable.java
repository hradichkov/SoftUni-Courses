package P03SetsAndMapsExercises;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

//            for (String element : data) {
//                elements.add(element);
//            }
            Collections.addAll(elements, data);
        }
        System.out.println(String.join(" ", elements));
    }
}
