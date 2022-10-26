package P06SOLID;

public abstract class Drink {
    private final double milliliters;
    private final double density;

    protected Drink(double milliliters, double density) {
        this.milliliters = milliliters;
        this.density = density;
    }

    public double getDensity() {
        return density;
    }

    public double getMilliliters() {
        return milliliters;
    }

    public double getDrinkAmountInLiters() {
        return 1000 / this.getMilliliters() * this.getDensity();
    }
}
