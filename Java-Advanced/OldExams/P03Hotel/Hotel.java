package OldExams.P03Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : roster) {
            if (person.getName().equals(name)) {
                roster.remove(person);
                return true;
            }
        }
        return false;
        //roster.removeIf(p -> p.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }
        return null;

//        roster.stream()
//                .filter(p -> p.getName().equals(name) && p.getHometown().equals(hometown))
//                .findFirst()
//                .orElseThrow(null);
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
//        return String.format("The people in the hotel %s are:%n", this.name) +
//                roster.stream()
//                        .map(p -> String.format("Person %s: %d, Age: %d, Hometown: %s", p.getName(), p.getId(), p.getAge(), p.getHometown()))
//                        .collect(Collectors.joining(System.lineSeparator()));

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", this.name));

        for (Person person : roster) {
            sb.append(String.format("%s%n", person.toString()));
        }
        return sb.toString().trim();
    }
}
