package P09DesignPatternsExercises.factoryPattern.cake;

public class BiscuitCake extends Cake {
    public BiscuitCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Prepare biscuit cake");
    }

    @Override
    public void bake() {
        System.out.println("Bake biscuit cake");
    }

    @Override
    public void box() {
        System.out.println("Box biscuit cake");
    }
}
