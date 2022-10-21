package P04InterfacesAndAbstraction.P03BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Identifiable> members = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] data = input.split(" ");

            Identifiable identifiable = data.length == 2
                    ? new Robot(data[1], data[0])
                    : new Citizen(data[0], Integer.parseInt(data[1]), data[2]);

            members.add(identifiable);

            input = scanner.nextLine();
        }

        String postfix = scanner.nextLine();

        members.stream()
                .map(Identifiable::getId)
                .filter(m -> m.endsWith(postfix))
                .forEach(System.out::println);

    }
}
