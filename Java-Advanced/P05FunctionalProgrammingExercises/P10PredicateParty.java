package P05FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestsList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] data = input.split(" ");
            String command = data[0];

            switch (command) {
                case "Remove" -> guestsList.removeIf(getPredicate(data));
                case "Double" -> {
                    List<String> peopleToAdd = guestsList.stream().filter(getPredicate(data)).collect(Collectors.toList());
                    guestsList.addAll(peopleToAdd);
                }
            }


            input = scanner.nextLine();
        }

        if (guestsList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(guestsList);

            System.out.println(String.join(", ", guestsList) + " are going to the party!");

//            for (String guest : guestsList) {
//                System.out.print(guest + ", ");
//            }
//            System.out.println("are going to the party!");
        }
    }

    public static Predicate<String> getPredicate(String[] data) {
        Predicate<String> predicate = null;
        String filterName = data[1];
        String filterCriteria = data[2];

        switch (filterName) {
            case "StartsWith" -> predicate = name -> name.startsWith(filterCriteria);
            case "EndsWith" -> predicate = name -> name.endsWith(filterCriteria);
            case "Length" -> {
                int length = Integer.parseInt(filterCriteria);
                predicate = name -> name.length() == length;
            }
        }
        return predicate;
    }
}
