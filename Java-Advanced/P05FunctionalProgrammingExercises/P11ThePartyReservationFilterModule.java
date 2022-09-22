package P05FunctionalProgrammingExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestsList = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        List<Predicate<String>> outputList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Print")) {
            String[] data = input.split(";");
            String command = data[0];

            switch (command) {
                case "Add filter":
                    guestsList.removeIf(getPredicate(data));
                    break;
                case "Remove filter":

                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print(String.join(" ", guestsList));
    }

    public static Predicate<String> getPredicate(String[] data) {
        Predicate<String> predicate = null;
        String fileType = data[1];
        String parameter = data[2];

        switch (fileType) {
            case "Starts with" -> predicate = name -> name.startsWith(parameter);
            case "Ends with" -> predicate = name -> name.endsWith(parameter);
            case "Length" -> predicate = name -> name.length() == Integer.parseInt(parameter);
            case "Contains" -> predicate = name -> name.contains(parameter);
        }
        return predicate;
    }
}
