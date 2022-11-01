package OldExams;

import java.util.*;
import java.util.stream.Collectors;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::push); // за stack

        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)); // за queue

        Map<String, Integer> cookedFoodsMap = new TreeMap<>();

        cookedFoodsMap.put("Bread", 0);
        cookedFoodsMap.put("Cake", 0);
        cookedFoodsMap.put("Pastry", 0);
        cookedFoodsMap.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int lastIngredient = ingredients.pop();
            int sum = liquids.poll() + lastIngredient;

            String cookedFood = switch (sum) {
                case 25 -> "Bread";
                case 50 -> "Cake";
                case 75 -> "Pastry";
                case 100 -> "Fruit Pie";
                default -> "";
            };

            if (!cookedFood.equals("")) {
                int newVal = cookedFoodsMap.get(cookedFood) + 1;
                cookedFoodsMap.put(cookedFood, newVal);
            } else {
                ingredients.push(lastIngredient + 3);
            }
        }

        boolean allFoodAreCooked = cookedFoodsMap.entrySet().stream().allMatch(e -> e.getValue() > 0);
        if (allFoodAreCooked) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        String remainingLiquids = liquids.isEmpty() ? "none" : liquids.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println("Liquids left: " + remainingLiquids);

        String remainingIngredients = ingredients.isEmpty() ? "none" : ingredients.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Ingredients left: " + remainingIngredients);

        cookedFoodsMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
