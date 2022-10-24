package P04InterfacesAndAbstractionExercises.P04FoodShortage;

public class Rebel implements Person, Buyer {

    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void buyFood() {
        food += 5;
    }

    @Override
    public int getFood() {
        return food;
    }

    public String getGroup() {
        return group;
    }
}