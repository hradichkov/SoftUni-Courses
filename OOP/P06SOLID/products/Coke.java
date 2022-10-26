package P06SOLID.products;

import P06SOLID.Drink;
import P06SOLID.Product;

public class Coke extends Drink implements Product {

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    private static final double DENSITY = 0.6;

    public Coke(double milliliters) {
        super(milliliters, DENSITY);
    }

    public double getMilliliters() {
        return this.getMilliliters();
    }

    @Override
    public double getAmountOfCalories() {
        return CALORIES_PER_100_GRAMS / 100 * (getMilliliters() * DENSITY);
    }
}
