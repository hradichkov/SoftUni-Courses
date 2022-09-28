package P07Generics;

public class P03Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public P03Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (left.compareTo(right) > 0) {
            return left;
        } else if (left.compareTo(right) < 0) {
            return right;
        }
        return null;
    }
}
