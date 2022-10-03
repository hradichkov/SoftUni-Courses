package P08IteratorsAndComparatorsExercises.P03ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public int compareTo(Person other) {
        if (this.name.equals(other.name)) {
            if (this.age == other.age) {
                return this.city.compareTo(other.city);
            }
            return Integer.compare(this.age, other.age);
        }
        return this.name.compareTo(other.name);
    }
}
