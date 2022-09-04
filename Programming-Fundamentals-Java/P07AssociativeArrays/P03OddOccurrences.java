package P07AssociativeArrays;

import java.util.*;
import java.util.stream.Collectors;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split(" ")).map(String::toLowerCase).collect(Collectors.toList());

        Map<String, Integer> inputMap = new LinkedHashMap<>();

        for (int i = 0; i < inputList.size(); i++) {
            String currentSymbol = inputList.get(i);

            if (inputMap.containsKey(currentSymbol)) {
                inputMap.put(currentSymbol, inputMap.get(currentSymbol) + 1);
            } else {
                inputMap.put(currentSymbol, 1);
            }
        }

        List<String> oddList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            if (inputMap.get(entry.getKey()) % 2 != 0) {
                oddList.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", oddList));
    }
}