package P02EncapsulationExercises.P04PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!"White".equals(flourType)
                && !"Wholegrain".equals(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!"Crispy".equals(bakingTechnique)
                && !"Chewy".equals(bakingTechnique)
                && !"Homemade".equals(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * weight) * getFlourTypeModifier() * getBakingTechniqueModifier();
    }

    private double getFlourTypeModifier() {
        return switch (flourType) {
            case "White" -> 1.5;
            case "Wholegrain" -> 1;
            default -> 1;
        };
    }

    private double getBakingTechniqueModifier() {
        return switch (bakingTechnique) {
            case "Crispy" -> 0.9;
            case "Chewy" -> 1.1;
            case "Homemade" -> 1;
            default -> 1;
        };
    }
}
