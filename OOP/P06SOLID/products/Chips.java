package P06SOLID.products;

import P06SOLID.Food;
import P06SOLID.Product;

public class Chips extends Food implements Product {

    public static final double CALORIES_PER_100_GRAMS = 529.0;

    public Chips(double grams) {
        super(grams);
    }

    public double getGrams() {
        return this.getGrams();
    }

    @Override
    public double getAmountOfCalories() {
        return CALORIES_PER_100_GRAMS / 100 * getGrams();
    }
}
