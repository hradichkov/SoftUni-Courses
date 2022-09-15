package P03SetsAndMaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> guests = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {
            if (input.length() == 8) {
                guests.add(input);
            }
            input = scanner.nextLine();
        }

        String guestReservation = scanner.nextLine();

        while (!guestReservation.equals("END")) {
            guests.remove(guestReservation);

            guestReservation = scanner.nextLine();
        }
        System.out.println(guests.size());
        System.out.println(String.join(System.lineSeparator(), guests));
    }
}
