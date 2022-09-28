package P07Generics;

import java.util.ArrayDeque;

public class P01Jar<E> {
    private ArrayDeque<E> elements;

    public P01Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(E element) {
        elements.push(element);
    }

    public E remove() {
        return elements.pop();
    }
}
