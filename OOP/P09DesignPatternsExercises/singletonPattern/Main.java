package P09DesignPatternsExercises.singletonPattern;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Owner owner = new Owner();

        owner.buyAnimals("Tiger", 10);
        employee.feedAnimals();
    }
}
