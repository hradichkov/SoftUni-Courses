package P07AssociativeArraysExercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> charsMap = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol != ' ') {
                if (charsMap.containsKey(symbol)) {
                    charsMap.put(symbol, charsMap.get(symbol) + 1);
                } else {
                    charsMap.put(symbol, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : charsMap.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
