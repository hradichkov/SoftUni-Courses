package P06SOLID;

import java.util.List;

public class CalorieCalculator {

    private Printer printer;
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    public double sum(List<Product> products) {

        double sum = products.stream()
                .mapToDouble(Product::getAmountOfCalories)
                .sum();

        printer.print(SUM, sum);

        return sum;
    }

    public double average(List<Product> products) {
        double amount = sum(products) / products.size();

        printer.print(AVERAGE, amount);

        return amount;
    }
}
