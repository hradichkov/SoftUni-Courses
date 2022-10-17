package P02EncapsulationExercises.P04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInput = scanner.nextLine().split(" ");
        String pizzaName = pizzaInput[1];
        int numberOfToppings = Integer.parseInt(pizzaInput[2]);

        String[] doughInput = scanner.nextLine().split(" ");
        String flourType = doughInput[1];
        String bakingTechnique = doughInput[2];
        double doughWeightInGrams = Double.parseDouble(doughInput[3]);

        try {
            Pizza pizza = new Pizza(pizzaName, numberOfToppings);
            Dough dough = new Dough(flourType, bakingTechnique, doughWeightInGrams);

            pizza.setDough(dough);


            String input = scanner.nextLine();

            while (!"END".equals(input)) {
                String[] toppingInput = input.split(" ");
                String toppingType = toppingInput[1];
                double toppingWeightInGrams = Double.parseDouble(toppingInput[2]);

                Topping topping = new Topping(toppingType, toppingWeightInGrams);
                pizza.addTopping(topping);

                input = scanner.nextLine();
            }

            System.out.printf("%s - %.2f", pizzaName, pizza.getOverallCalories());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
