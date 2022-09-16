package P03SetsAndMapsExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            if (map.containsKey(currentCharacter)) {
                map.put(currentCharacter, map.get(currentCharacter) + 1);
            } else {
                map.put(currentCharacter, 1);
            }
        }

//        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s"));
//        map.forEach((key, value) -> System.out.println(key + " : " + value + "time/s"));

        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            System.out.printf("%c: %d time/s%n", pair.getKey(), pair.getValue());
        }
//        for (var pair : map.entrySet()) {
//            System.out.printf("%c: %d time/s%n", pair.getKey(), pair.getValue());
//        }
    }
}
