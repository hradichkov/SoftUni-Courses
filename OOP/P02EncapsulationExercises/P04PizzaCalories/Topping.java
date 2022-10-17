package P02EncapsulationExercises.P04PizzaCalories;

public class Topping {
    private String toppingType;
    //private ToppingTypes toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setToppingType(String toppingType) {
//        boolean toppingExists = Arrays.stream(ToppingTypes.values()).anyMatch(t -> t.name().equals(toppingType));
//
//        if (toppingExists) {
//            this.toppingType = ToppingTypes.valueOf(toppingType);
//        } else {
//            String exceptionMessage = String.format("Cannot place %s on top of your pizza.", toppingType);
//            throw new IllegalArgumentException(exceptionMessage);
//        }
        if (!"Meat".equals(toppingType)
                && !"Veggies".equals(toppingType)
                && !"Cheese".equals(toppingType)
                && !"Sauce".equals(toppingType)) {

            String exceptionMessage = String.format("Cannot place %s on top of your pizza.", toppingType);
            throw new IllegalArgumentException(exceptionMessage);
        }
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * weight) * getToppingTypeModifier();
    }

    private double getToppingTypeModifier() {
        return switch (toppingType) {
            case "Meat" -> 1.2;
            case "Veggies" -> 0.8;
            case "Cheese" -> 1.1;
            case "Sauce" -> 0.9;
            default -> 1;
        };

        //return toppingType.getModifier();
    }
}
