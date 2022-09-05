package P07AssociativeArraysExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int shards = 0;
        int fragments = 0;
        int motes = 0;

        Map<String, Integer> materialMap = new LinkedHashMap<>();
        materialMap.put("shards", 0);
        materialMap.put("fragments", 0);
        materialMap.put("motes", 0);

        Map<String, Integer> junksMap = new LinkedHashMap<>();
        boolean isOver = false;

        while (!isOver) {
            String[] input = scanner.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < input.length; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1];

                if (materialMap.containsKey(material)) {
                    materialMap.put(material, materialMap.get(material) + quantity);

                    if (materialMap.get(material) >= 250) {
                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                        } else if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                        } else {
                            System.out.println("Dragonwrath obtained!");
                        }
                        materialMap.put(material, materialMap.get(material) - 250);
                        isOver = true;
                        break;
                    }

                } else {
                    if (junksMap.containsKey(material)) {
                        junksMap.put(material, junksMap.get(material) + quantity);
                    } else {
                        junksMap.put(material, quantity);
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> entry : materialMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : junksMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
