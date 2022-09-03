package P06ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P07OrderByAge {

    static class Person {
        private String name;
        private String id;
        private int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public Integer getAge() {
            return this.age;
        }

        @Override
        public String toString() {
           // return this.name + " with ID: " + this.id + " is " + this.age + " years old.";
            return String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> personList = new ArrayList<>();

        while (!input.equals("End")) {
            String name = input.split(" ")[0];
            String id = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);

            Person person = new Person(name, id, age);
            personList.add(person);

            input = scanner.nextLine();
        }
        personList.sort(Comparator.comparing(Person::getAge));

        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
