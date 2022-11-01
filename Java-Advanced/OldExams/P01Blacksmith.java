package OldExams;

import java.util.*;
import java.util.stream.Collectors;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // queue

        ArrayDeque<Integer> carbonStack = new ArrayDeque<>(); // stack

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(carbonStack::push);

        Map<String, Integer> swordsMap = new TreeMap<>();
        int totalSwords = 0;

        while (!carbonStack.isEmpty() && !steelQueue.isEmpty()) {
            int steel = steelQueue.poll();
            int carbon = carbonStack.pop();
            int sum = carbon + steel;

            String forgedSWord = switch (sum) {
                case 70 -> "Gladius";
                case 80 -> "Shamshir";
                case 90 -> "Katana";
                case 110 -> "Sabre";
                default -> null;
            };

            if (forgedSWord != null) {
                totalSwords++;
                swordsMap.putIfAbsent(forgedSWord, 0);
                swordsMap.put(forgedSWord, swordsMap.get(forgedSWord) + 1);
            } else {
                carbonStack.push(carbon + 5);
            }
        }
        if (totalSwords != 0) {
            System.out.println("You have forged " + totalSwords + " swords.");
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        String remainingSteel = steelQueue.isEmpty() ? "none" : steelQueue.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Steel left: " + remainingSteel);

        String remainingCarbon = carbonStack.isEmpty() ? "none" : carbonStack.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Carbon left: " + remainingCarbon);


        swordsMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
