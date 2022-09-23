package P06DefiningClasses.P05OpinionPoll;

public class OpinionPoll {
    private String name;
    private int age;

    OpinionPoll(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return String.format("%s - %d", this.name, this.age);
    }
}
