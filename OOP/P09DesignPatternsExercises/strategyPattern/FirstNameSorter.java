package P09DesignPatternsExercises.strategyPattern;

import java.util.Collections;
import java.util.Comparator;

public class FirstNameSorter implements Comparator<Person> {

    @Override
    public int compare(Person left, Person right) {
        return left.getFirstName().compareTo(right.getFirstName());
    }

    public Comparator<Person> reversed() {
        return Collections.reverseOrder(this);
    }
}
