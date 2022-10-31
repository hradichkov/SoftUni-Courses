package P09DesignPatternsExercises.factoryPattern;

import P09DesignPatternsExercises.factoryPattern.cake.Cake;
import P09DesignPatternsExercises.factoryPattern.cake.CakeFactory;

public class PastryShop {
    public static Cake orderCake(String cakeType) {
        Cake cake = CakeFactory.createCake(cakeType);
        cake.prepare();
        cake.bake();
        cake.box();

        return cake;
    }
}
