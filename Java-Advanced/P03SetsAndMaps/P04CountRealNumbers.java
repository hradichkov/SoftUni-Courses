package P03SetsAndMaps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> numbersMap = new LinkedHashMap<>();
//        double[] data = Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToDouble(Double::parseDouble)
//                .toArray();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(key -> {
                    if (!numbersMap.containsKey(key)) {
                        numbersMap.put(key, 1);
                    } else {
                        int oldValue = numbersMap.get(key);
                        int newValue = oldValue + 1;
                        numbersMap.put(key, newValue);
                    }
                });

//        for (double num : data) {
//            if (!numbersMap.containsKey(num)) {
//                numbersMap.put(num, 1);
//            } else {
//                int oldValue = numbersMap.get(num);
//                int newValue = oldValue + 1;
//                numbersMap.put(num, newValue);
//            }
//        }

        for (Map.Entry<Double, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
