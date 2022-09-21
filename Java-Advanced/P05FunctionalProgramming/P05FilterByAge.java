package P05FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05FilterByAge {
    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person p = new Person(name, age);
            people.add(p);
        }

        String ageCondition = scanner.nextLine();
        int ageFilter = Integer.parseInt(scanner.nextLine());
        String outputFormat = scanner.nextLine();

        people = filterByAgeCondition(people, getPredicate(ageCondition, ageFilter));

        Consumer<Person> printer = getPrinter(outputFormat);
        people.forEach(printer);
    }

    private static Consumer<Person> getPrinter(String outputFormat) {
        return switch (outputFormat) {
            case "name" -> person -> System.out.println(person.name);
            case "age" -> person -> System.out.println(person.age);
            case "name age" -> person -> System.out.println(person.name + " - " + person.age);
            default -> null;
        };
    }

    private static Predicate<Person> getPredicate(String ageCondition, int ageFilter) {
        return switch (ageCondition) {
            case "older" -> p -> p.age >= ageFilter;
            case "younger" -> p -> p.age <= ageFilter;
            default -> null;
        };
    }

    private static List<Person> filterByAgeCondition(List<Person> people, Predicate<Person> predicate) {
        return people.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
