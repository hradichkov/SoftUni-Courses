package P09DesignPatternsExercises.factoryPattern.cake;

public class CakeFactory {
    public static Cake createCake(String cakeType) {

        return switch (cakeType) {
            case "Chocolate" -> new ChocolateCake(10, 10, 10);
            case "Biscuit" -> new BiscuitCake(20, 20, 20);
            default -> null;
        };
    }
}
