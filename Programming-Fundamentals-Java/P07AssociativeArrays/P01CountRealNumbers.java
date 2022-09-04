package P07AssociativeArrays;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numsMap = new TreeMap<>();

        for (int i = 0; i < numsArr.length; i++) {
            if (numsMap.containsKey(numsArr[i])) {
                numsMap.put(numsArr[i], numsMap.get(numsArr[i]) + 1);
            } else {
                numsMap.put(numsArr[i], 1);
            }
        }

        for (Map.Entry<Double, Integer> num : numsMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", num.getKey(), num.getValue());
        }

    }
}
