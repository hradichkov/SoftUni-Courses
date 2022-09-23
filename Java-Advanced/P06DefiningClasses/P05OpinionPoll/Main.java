package P06DefiningClasses.P05OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<OpinionPoll> personList = new ArrayList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            OpinionPoll person = new OpinionPoll(name, age);
            personList.add(person);
        }

        personList.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(OpinionPoll::getName))
                //.sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);
    }
}
