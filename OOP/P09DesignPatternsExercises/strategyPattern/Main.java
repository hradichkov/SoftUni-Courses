package P09DesignPatternsExercises.strategyPattern;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        Person person = new Person("Ivan", "Ivanov");
        Person person2 = new Person("Stoqn", "Ivanov");
        Person person3 = new Person("Kaloqn", "Ivanov");

        people.add(person);
        people.add(person2);
        people.add(person3);

        people.sort(new FirstNameSorter());
        people.sort(new FirstNameSorter().reversed());
        people.sort(new LastNameSorter());
    }
}
