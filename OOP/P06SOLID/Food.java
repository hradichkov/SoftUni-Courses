package P06SOLID;

public abstract class Food {
    private double grams;

    public Food(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    public double getFoodAmountInKg() {
        return 1000 / this.getGrams();
    }
}
