package P09DesignPatternsExercises.singletonPattern;

public class Employee {

    public  void feedAnimals(){
        Zoo.getInstance().getAnimals().keySet().forEach(a -> System.out.println("Feeding animal " + a));
    }
}
