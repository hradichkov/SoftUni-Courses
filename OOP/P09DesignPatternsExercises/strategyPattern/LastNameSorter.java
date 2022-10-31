package P09DesignPatternsExercises.strategyPattern;

import java.util.Comparator;

public class LastNameSorter implements Comparator<Person> {
    @Override
    public int compare(Person left, Person right) {
        return left.getLastName().compareTo(right.getLastName());
    }
}
