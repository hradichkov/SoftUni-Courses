package P09DesignPatternsExercises.singletonPattern;

import java.util.HashMap;

public class Zoo {

    private final HashMap<String, Integer> animals;
    private static Zoo instance;

    private Zoo() {
        animals = new HashMap<>();
    }

    public static Zoo getInstance() {
        if (instance == null) {
            instance = new Zoo();
        }
        return instance;
    }

    public HashMap<String, Integer> getAnimals() {
        return animals;
    }
}
