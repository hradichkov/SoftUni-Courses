package P08IteratorsAndComparatorsExercises.P03ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> personList = new ArrayList<>();

        while (!input.equals("END")) {
            String[] data = input.split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String city = data[2];

            Person person = new Person(name, age, city);
            personList.add(person);

            input = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine());
        Person personToCompare = personList.get(n - 1);

        int totalNum = personList.size();
        int samePeople = 0;
        int differentPeople = 0;

        for (Person person : personList) {
            if (person.compareTo(personToCompare) == 0) {
                samePeople++;
            } else {
                differentPeople++;
            }
        }
        if (samePeople == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", samePeople, differentPeople, totalNum);
        }

    }
}
