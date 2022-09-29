package P07GenericsExercises.P04CustomListSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> customList;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public void add(T element) {
        customList.add(element);
    }

    public T remove(int index) {
        return customList.remove(index);
    }

    public boolean contains(T element) {
        return customList.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(customList, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        return (int) customList.stream()
                .filter(currentElement -> currentElement.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return customList.stream()
                .max(Comparable::compareTo)
                .get();
    }

    public T getMin() {
        return customList.stream()
                .min(Comparable::compareTo)
                .get();
    }

    public int size() {
        return customList.size();
    }

    public T get(int index) {
        return customList.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : customList) {
            sb.append(String.format("%s%n", element.toString()));
        }
        return sb.toString().trim();
    }
}
