package P07GenericsExercises.P03GenericCountMethod;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public int count(T element) {
        return (int) values.stream()
                .filter(itemFromOurBox -> itemFromOurBox.compareTo(element) > 0)
                .count();
    }
}
